package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import main.states.EndMenuState;
import main.states.GameState;
import main.states.StartMenuState;
import main.states.State;

/**
 *
 * @author Alex
 */
public class Main extends Loop{
   
    private Display display;
    private BufferStrategy bs;
    private Graphics g;
    public static int width, height;
    
    public static final String VERSION = "V. Alpha 3.0";
    
    private double score=0;
    
    private State startMenuState;
    private State gameState;
    private State endMenuState;
    
    private Player player;
    
    @Override
    public void startup() {
        width = 1080;
        height = 720; 
        display = new Display("Chasey Atom", width, height);
        
        player = new Player();
        
        startMenuState = new StartMenuState(this);
        gameState = new GameState(this);
        endMenuState = new EndMenuState(this);
        
        State.setState(startMenuState);
        
        display.getFrame().addMouseMotionListener(player);
        display.getCanvas().addMouseMotionListener(player);
        display.getFrame().addMouseListener(player);
        display.getCanvas().addMouseListener(player);
        
    }

    @Override
    public void shutdown() {
        
    }

    @Override
    public void update() {
        State.getState().update();
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
        
        State.getState().render(g);
        
        bs.show();
        g.dispose();
    }
    
    public double getScore(){return score;}
    public void setScore(double score){this.score = score;}
    
    public Player getPlayer(){return player;}
    
    public State getStartMenuState(){return startMenuState;}
    public State getGameState(){return gameState;}
    public State getEndMenuState(){return endMenuState;}
}
