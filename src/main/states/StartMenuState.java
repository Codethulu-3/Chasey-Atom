package main.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import main.Button;
import main.Main;
import static main.Main.height;
import static main.Main.width;
import main.Player;

/**
 *
 * @author Alex
 */
public class StartMenuState extends State{
    
    private Button startButton;
    private Button endButton;
    private Player player;
    
    public StartMenuState(Main main){
        super(main);
        player = main.getPlayer();
        startButton = new Button(Color.darkGray, Color.green,width/2 - 128, height/3, 256,64, "Start Game");
        endButton = new Button(Color.darkGray, Color.green,width/2 - 128, height/2, 256,64, "Exit Game");
    }
    
    @Override
    public void update() {
        startButton.update((int)player.getMouseX(), (int)player.getMouseY());
        endButton.update((int)player.getMouseX(), (int)player.getMouseY());
        
        if(startButton.click(player.getLeftPressed())){
            State.setState(main.getGameState());
        }
        if(endButton.click(player.getLeftPressed())){
            System.exit(0);
        }
    }

    @Override
    public void render(Graphics g) {
        startButton.render(g);
        endButton.render(g);
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        g.setColor(Color.yellow);
        g.drawString("Chasey Atom", (width/2) - (g.getFontMetrics().stringWidth("Chasey Atom") / 2), (height/4) - 32);
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        g.setColor(Color.white);
        g.drawString(startButton.getText(), (width/2) - (g.getFontMetrics().stringWidth(startButton.getText()) / 2), (height/3 + 32));
        g.drawString(endButton.getText(), (width/2) - (g.getFontMetrics().stringWidth(endButton.getText()) / 2), (height/2 + 32));
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        g.setColor(Color.white);
        g.drawString(Main.VERSION, 0,12);
    }

    @Override
    public void reloadState() {
    }
    
    
}
