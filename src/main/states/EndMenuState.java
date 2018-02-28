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
public class EndMenuState extends State{
    
    private Button replayButton;
    private Button endButton;
    private Player player;
    
    public EndMenuState(Main main){
        super(main);
        player = main.getPlayer();
        replayButton = new Button(Color.darkGray, Color.green,width/2 - 128, height/3, 256,64, "Play Again");
        endButton = new Button(Color.darkGray, Color.green,width/2 - 128, height/2, 256,64, "Exit Game");
    }

    @Override
    public void update() {
        replayButton.update((int)player.getMouseX(), (int)player.getMouseY());
        endButton.update((int)player.getMouseX(), (int)player.getMouseY());
        
        if(replayButton.click(player.getLeftPressed())){
            State.setState(main.getGameState());
        }
        if(endButton.click(player.getLeftPressed())){
            System.exit(0);
        }
    }

    @Override
    public void render(Graphics g) {
        replayButton.render(g);
        endButton.render(g);
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        g.setColor(Color.yellow);
        g.drawString("Ur Bad Lol", (width/2) - (g.getFontMetrics().stringWidth("Ur Bad Lol") / 2), (height/4) - 32);
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        g.setColor(Color.white);
        g.drawString(replayButton.getText(), (width/2) - (g.getFontMetrics().stringWidth(replayButton.getText()) / 2), (height/3 + 32));
        g.drawString(endButton.getText(), (width/2) - (g.getFontMetrics().stringWidth(endButton.getText()) / 2), (height/2 + 32));
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        g.setColor(Color.white);
        g.drawString("Score: " + (int)main.getScore(), (width/2) - (g.getFontMetrics().stringWidth("Score: 999") / 2), (((height/4) + height/3)/2)-16);
    }

    @Override
    public void reloadState() {
    }
    
}
