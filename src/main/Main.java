package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Main extends Loop{
   
    private Display display;
    private BufferStrategy bs;
    private Graphics g;
    public static int width, height;
    
    private int state=0;
    
    private Button startButton;
    private Button endButton;
    private Button replayButton;
    
    public static double k = 8987552787.37;
    public static double e = -1.60217662 * Math.pow(10,-4);
    private ArrayList<Charge> electrons = new ArrayList();
    private long lastSpawn, spawnTimer = lastSpawn, spawnCooldown=2000;
    private ArrayList<Charge> protons = new ArrayList();
    private long lastpSpawn, pspawnTimer = lastpSpawn, pspawnCooldown=6000;
    
    private Player player;
    private double score = 0;
    
    @Override
    public void startup() {
        width = 1080;
        height = 720; 
        display = new Display("Chasey Atom", width, height);
        
        for(int i = 0; i < 2; i++){
            electrons.add(new Charge(Math.random() * 1080, Math.random()* 720, e));
        }
        
        player = new Player();
        
        display.getFrame().addMouseMotionListener(player);
        display.getCanvas().addMouseMotionListener(player);
        display.getFrame().addMouseListener(player);
        display.getCanvas().addMouseListener(player);
        
        startButton = new Button(Color.darkGray, Color.green,width/2 - 128, height/3, 256,64, "Start Game");
        endButton = new Button(Color.darkGray, Color.green,width/2 - 128, height/2, 256,64, "Exit Game");
        
        replayButton = new Button(Color.darkGray, Color.green,width/2 - 128, height/3, 256,64, "Play Again");
    }

    @Override
    public void shutdown() {
        
    }

    @Override
    public void update() {
        switch (state) {
            case 0:
                startMenu();
                break;
            case 1:
                game();
                break;
            default:
                endMenu();
                break;
        }
    }
    
    private void startMenu(){
        startButton.update((int)player.getMouseX(), (int)player.getMouseY());
        endButton.update((int)player.getMouseX(), (int)player.getMouseY());
        
        if(startButton.click(player.getLeftPressed())){
            state=1;
        }
        if(endButton.click(player.getLeftPressed())){
            System.exit(0);
        }
    }
    
    private void game(){
        for (int i = 0; i < electrons.size(); i++) {
            for (int j = 0; j < electrons.size(); j++) {
                if (j != i) {
                    double d = Math.sqrt(Math.pow(electrons.get(i).getX() - electrons.get(j).getX(), 2)
                            + Math.pow(electrons.get(i).getY() - electrons.get(j).getY(), 2));
                    double theta = Math.atan2(electrons.get(i).getX() - electrons.get(j).getX(),
                            electrons.get(i).getY() - electrons.get(j).getY());
                    if (theta < 0) {
                        theta += 2 * Math.PI;
                    }
                    double magnitude = (k * electrons.get(i).getCharge()
                            * electrons.get(j).getCharge()) / Math.pow(d, 2);
                    if (electrons.get(i).getCharge() <= 0 && electrons.get(j).getCharge() <= 0) {
                        magnitude *= -1;
                    }
                    if (electrons.get(i).getCharge() >= 0 && electrons.get(j).getCharge() >= 0) {
                        magnitude *= -1;
                    }
                    electrons.get(j).setAx(magnitude * Math.sin(theta));
                    electrons.get(j).setAy(magnitude * Math.cos(theta));
                }
            }
        }
        for (Charge c : electrons) {
            c.update();
        }

        spawnTimer += System.currentTimeMillis() - lastSpawn;
        lastSpawn = System.currentTimeMillis();
        if (spawnTimer > spawnCooldown) {
            electrons.add(new Charge(Math.random() * 1080, Math.random() * 720, e));
            spawnTimer = 0;
        }
        
        for(int i = 0; i < electrons.size(); i++){
            if(player.collision(electrons.get(i).getX(), electrons.get(i).getY(), electrons.get(i).getRadius())){
                state=2;
            }
        }
        
        pspawnTimer += System.currentTimeMillis() - lastpSpawn;
        lastpSpawn = System.currentTimeMillis();
        if (pspawnTimer > pspawnCooldown) {
            protons.add(new Charge(Math.random() * 1080, Math.random() * 720, -e));
            pspawnTimer = 0;
        }
        
        for(int i = 0; i < protons.size(); i++){
            if(player.collision(protons.get(i).getX(), protons.get(i).getY(), protons.get(i).getRadius())){
                score+=50;
                protons.remove(i);
                electrons.remove(0);
            }
        }
        
        score+=.01;
    }
    
    private void endMenu(){
        replayButton.update((int)player.getMouseX(), (int)player.getMouseY());
        endButton.update((int)player.getMouseX(), (int)player.getMouseY());
        
        if(replayButton.click(player.getLeftPressed())){
            electrons.removeAll(electrons);
            for(int i = 0; i < 2; i++){
                electrons.add(new Charge(Math.random() * 1080, Math.random()* 720, e));
            }
            score=0;
            state=1;
        }
        if(endButton.click(player.getLeftPressed())){
            System.exit(0);
        }
    }
    
    @Override
    public void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        
        g.setColor(new Color(135, 165, 255));
        g.fillRect(0, 0, width, height);
        
        switch (state) {
            case 0:
                drawStartMenu(g);
                break;
            case 1:
                drawGame(g);
                break;
            default:
                drawEndMenu(g);
                break;
        }
        
        bs.show();
        g.dispose();
    }
    
    private void drawStartMenu(Graphics g){
        startButton.render(g);
        endButton.render(g);
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        g.setColor(Color.yellow);
        g.drawString("Chasey Atom", (width/2) - (g.getFontMetrics().stringWidth("Chasey Atom") / 2), (height/4) - 32);
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        g.setColor(Color.white);
        g.drawString(startButton.getText(), (width/2) - (g.getFontMetrics().stringWidth(startButton.getText()) / 2), (height/3 + 32));
        g.drawString(endButton.getText(), (width/2) - (g.getFontMetrics().stringWidth(endButton.getText()) / 2), (height/2 + 32));
    }
    
    private void drawGame(Graphics g){
        for(Charge c: electrons){
            c.render(g);
        }
        
        for(Charge c: protons){
            c.render(g);
        }
        
        
        player.render(g);
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        g.setColor(Color.white);
        g.drawString(("Score: " + Integer.toString((int)score)), 0,18);
    }
    
    private void drawEndMenu(Graphics g){
        replayButton.render(g);
        endButton.render(g);
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        g.setColor(Color.yellow);
        g.drawString("Ur Bad Lol", (width/2) - (g.getFontMetrics().stringWidth("Chasey Atom") / 2), (height/4) - 32);
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        g.setColor(Color.white);
        g.drawString(replayButton.getText(), (width/2) - (g.getFontMetrics().stringWidth(replayButton.getText()) / 2), (height/3 + 32));
        g.drawString(endButton.getText(), (width/2) - (g.getFontMetrics().stringWidth(endButton.getText()) / 2), (height/2 + 32));
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        g.setColor(Color.white);
        g.drawString(("Score: " + Integer.toString((int)score)), 0,18);
    }
}
