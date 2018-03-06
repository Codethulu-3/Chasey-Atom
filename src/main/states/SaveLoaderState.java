package maze.states;

/**
*
* @author Ryan
*/

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
 * @author Alex and Ryan
 */
public class SaveLoaderState extends State{
    
	//DONE for v1
	
    private Button save1Button;
    private Button save2Button;
    private Button save3Button;
    private Button save4Button;
    private Button save5Button;
    private Button save6Button;
    private Button save7Button;
    private Button save8Button;
    private Button save9Button;
    private Button save10Button;
    private Button backButton;
    private Player player;
    private Character pc;
    
    public SaveLoaderState(Main main){
        super(main);
        player = main.getPlayer();
        pc = main.getCharacter();
        save1Button = new Button(Color.darkGray, Color.green,width/3 - 128, height/6, 256,64, "Save 1");
        save2Button = new Button(Color.darkGray, Color.green,width/3 - 128, height*2/6, 256,64, "Save 2");
        save3Button = new Button(Color.darkGray, Color.green,width/3 - 128, height*3/6, 256,64, "Save 3");
        save4Button = new Button(Color.darkGray, Color.green,width/3 - 128, height*4/6, 256,64, "Save 4");
        save5Button = new Button(Color.darkGray, Color.green,width/3 - 128, height*5/6, 256,64, "Save 5");
        save6Button = new Button(Color.darkGray, Color.green,width*2/3 - 128, height/6, 256,64, "Save 6");
        save7Button = new Button(Color.darkGray, Color.green,width*2/3 - 128, height*2/6, 256,64, "Save 7");
        save8Button = new Button(Color.darkGray, Color.green,width*2/3 - 128, height*3/6, 256,64, "Save 8");
        save9Button = new Button(Color.darkGray, Color.green,width*2/3 - 128, height*4/6, 256,64, "Save 9");
        save10Button = new Button(Color.darkGray, Color.green,width*2/3 - 128, height*5/6, 256,64, "Save 10");
        backButton = new Button(Color.darkGray, Color.green,width*1/8 - 128, height*1/8, 32,32, "<==");
    }
    
    @Override
    public void update() {
        save1Button.update((int)player.getMouseX(), (int)player.getMouseY());
        save2Button.update((int)player.getMouseX(), (int)player.getMouseY());
        save3Button.update((int)player.getMouseX(), (int)player.getMouseY());
        save4Button.update((int)player.getMouseX(), (int)player.getMouseY());
        save5Button.update((int)player.getMouseX(), (int)player.getMouseY());
        save6Button.update((int)player.getMouseX(), (int)player.getMouseY());
        save7Button.update((int)player.getMouseX(), (int)player.getMouseY());
        save8Button.update((int)player.getMouseX(), (int)player.getMouseY());
        save9Button.update((int)player.getMouseX(), (int)player.getMouseY());
        save10Button.update((int)player.getMouseX(), (int)player.getMouseY());
        backButton.update((int)player.getMouseX(), (int)player.getMouseY());
        
        if(save1Button.click(player.getLeftPressed())){
            pc.loadSave("save1");
        	State.setState(main.getGameState());
        }
        if(save2Button.click(player.getLeftPressed())){
            pc.loadSave("save2");
        	State.setState(main.getGameState());
        }
        if(save3Button.click(player.getLeftPressed())){
            pc.loadSave("save3");
        	State.setState(main.getGameState());
        }
        if(save4Button.click(player.getLeftPressed())){
            pc.loadSave("save4");
        	State.setState(main.getGameState());
        }
        if(save5Button.click(player.getLeftPressed())){
            pc.loadSave("save5");
        	State.setState(main.getGameState());
        }
        if(save6Button.click(player.getLeftPressed())){
            pc.loadSave("save6");
        	State.setState(main.getGameState());
        }
        if(save7Button.click(player.getLeftPressed())){
            pc.loadSave("save7");
        	State.setState(main.getGameState());
        }
        if(save8Button.click(player.getLeftPressed())){
            pc.loadSave("save8");
        	State.setState(main.getGameState());
        }
        if(save9Button.click(player.getLeftPressed())){
            pc.loadSave("save9");
        	State.setState(main.getGameState());
        }
        if(save10Button.click(player.getLeftPressed())){
            pc.loadSave("save10");
        	State.setState(main.getGameState());
        }
        if(backButton.click(player.getLeftPressed())){
        	State.setState(State.getLastState());
        }
    }

    @Override
    public void render(Graphics g) {
        save1Button.render(g);
        save2Button.render(g);
        save3Button.render(g);
        save4Button.render(g);
        save5Button.render(g);
        save6Button.render(g);
        save7Button.render(g);
        save8Button.render(g);
        save9Button.render(g);
        save10Button.render(g);
        backButton.render(g);
        
        g.setFont(new Font("Impact", Font.BOLD, 32));
        g.setColor(Color.yellow);
        g.drawString("Choose Save to Load", (width/2) - (g.getFontMetrics().stringWidth("Choose Save to Load") / 2), (height/7) - 32);
        
        g.setFont(new Font("Book Antiqua", Font.BOLD, 12));
        g.setColor(Color.white);
        g.drawString(save1Button.getText(), (width/3) - (g.getFontMetrics().stringWidth(save1Button.getText()) / 2), (height/6 + 32));
        g.drawString(save2Button.getText(), (width/3) - (g.getFontMetrics().stringWidth(save2Button.getText()) / 2), (height*2/6 + 32));
        g.drawString(save3Button.getText(), (width/3) - (g.getFontMetrics().stringWidth(save3Button.getText()) / 2), (height*3/6 + 32));
        g.drawString(save4Button.getText(), (width/3) - (g.getFontMetrics().stringWidth(save4Button.getText()) / 2), (height*4/6 + 32));
        g.drawString(save5Button.getText(), (width/3) - (g.getFontMetrics().stringWidth(save5Button.getText()) / 2), (height*5/6 + 32));
        g.drawString(save6Button.getText(), (width*2/3) - (g.getFontMetrics().stringWidth(save6Button.getText()) / 2), (height/6 + 32));
        g.drawString(save7Button.getText(), (width*2/3) - (g.getFontMetrics().stringWidth(save7Button.getText()) / 2), (height*2/6 + 32));
        g.drawString(save8Button.getText(), (width*2/3) - (g.getFontMetrics().stringWidth(save8Button.getText()) / 2), (height*3/6 + 32));
        g.drawString(save9Button.getText(), (width*2/3) - (g.getFontMetrics().stringWidth(save9Button.getText()) / 2), (height*4/6 + 32));
        g.drawString(save10Button.getText(), (width*2/3) - (g.getFontMetrics().stringWidth(save10Button.getText()) / 2), (height*5/6 + 32));
        g.drawString(backButton.getText(), (width/8) - (g.getFontMetrics().stringWidth(backButton.getText()) / 2), (height/2 + 32));
        
    }

    @Override
    public void reloadState() {
    }
    
    
}
