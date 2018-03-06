package maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Button {
    
    private Color button;
    private Color highlightButton;
    private int x,y;
    private int width, height;
    private String text;
    
    private boolean highlighted=false;
    
    private boolean clickable=true;
    private BufferedImage inactiveTexture;
    
    public Button(Color button, Color highlightButton, int x, int y, int width, int height, String text){
        this.button = button;
        this.highlightButton = highlightButton;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        clickable=true;
    }
    
    public void update(int mousex, int mousey){
        if(mousex > x && mousex < x + width){
            if(mousey > y && mousey < y + height){
                highlighted = true;
            } else {
                highlighted = false;
            }
        } else {
            highlighted = false;
        }
        
    }
    
    public void render(Graphics g){
        if(highlighted){
            g.setColor(highlightButton);
        } else {
            g.setColor(button);
        }
        g.fillRect(x, y, width, height);
    }
    
    public boolean click(boolean leftpress){
        if(clickable==false){
            return false;
        }
        if(highlighted){
            if(leftpress){
                return true;
            }
        }
        return false;
    }
    
    //getters & setters
    public String getText(){return text;}
    public int getY(){return y;}
    
    public void setClickable(boolean clickable){this.clickable = clickable;}
}
