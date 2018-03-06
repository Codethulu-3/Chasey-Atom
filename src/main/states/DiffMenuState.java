package maze.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import maze.Button;
import maze.Main;
import maze.Character;
import static maze.Main.height;
import static maze.Main.width;
import maze.Player;

/**
 *
 * @author Ryan
 */
public class DiffMenuState extends State{
    
	//DONE for v1
	
    private Button easyButton;
    private Button mediumButton;
    private Button hardButton;
    private Button MLGButton;
    private Button backButton;
    private Player player;
    private Character pc;
    
    public DiffMenuState(Main main){
        super(main);
        player = main.getPlayer();
        pc = main.getCharacter();
        easyButton = new Button(Color.darkGray, Color.green,width/2 - 128, height/5, 256,64, "Start Game");
        mediumButton = new Button(Color.darkGray, Color.green,width/2 - 128, height*2/5, 256,64, "Exit Game");
        hardButton = new Button(Color.darkGray, Color.green,width/2 - 128, height*3/5, 256,64, "Exit Game");
        MLGButton = new Button(Color.darkGray, Color.green,width/2 - 128, height*4/5, 256,64, "Exit Game");
        backButton = new Button(Color.darkGray, Color.green,width*1/8 - 128, height*1/8, 32,32, "<==");
    }
    
    @Override
    public void update() {
        easyButton.update((int)player.getMouseX(), (int)player.getMouseY());
        mediumButton.update((int)player.getMouseX(), (int)player.getMouseY());
        hardButton.update((int)player.getMouseX(), (int)player.getMouseY());
        MLGButton.update((int)player.getMouseX(), (int)player.getMouseY());
        backButton.update((int)player.getMouseX(), (int)player.getMouseY());
        
        if(easyButton.click(player.getLeftPressed())){
            pc.setdifficulty(0);
        	State.setState(main.getGameState());
        }
        if(mediumButton.click(player.getLeftPressed())){
        	pc.setdifficulty(1);
        	State.setState(main.getGameState());
        }
        if(hardButton.click(player.getLeftPressed())){
        	pc.setdifficulty(2);
        	State.setState(main.getGameState());
        }
        if(MLGButton.click(player.getLeftPressed())){
        	pc.setdifficulty(3);
        	State.setState(main.getGameState());
        }
        if(backButton.click(player.getLeftPressed())){
        	State.setState(State.getLastState());
        }
    }

    @Override
    public void render(Graphics g) {
        easyButton.render(g);
        mediumButton.render(g);
        hardButton.render(g);
        MLGButton.render(g);
        backButton.render(g);
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        g.setColor(Color.yellow);
        g.drawString("Choose Difficulty", (width/2) - (g.getFontMetrics().stringWidth("Choose Difficulty") / 2), (height/4) - 32);
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        g.setColor(Color.white);
        g.drawString(easyButton.getText(), (width/2) - (g.getFontMetrics().stringWidth(easyButton.getText()) / 2), (height/3 + 32));
        g.drawString(mediumButton.getText(), (width/2) - (g.getFontMetrics().stringWidth(mediumButton.getText()) / 2), (height/2 + 32));
        g.drawString(hardButton.getText(), (width/2) - (g.getFontMetrics().stringWidth(hardButton.getText()) / 2), (height/3 + 32));
        g.drawString(MLGButton.getText(), (width/2) - (g.getFontMetrics().stringWidth(MLGButton.getText()) / 2), (height/3 + 32));
        g.drawString(backButton.getText(), (width/2) - (g.getFontMetrics().stringWidth(backButton.getText()) / 2), (height/3 + 32));
        
    }

    @Override
    public void reloadState() {
    }
    
    
}
