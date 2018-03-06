package maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Alex
 */
public class Player implements MouseMotionListener, MouseListener{
    
    private double x,y;
    private double radius = 10;
    private boolean leftPressed;
    
    public Player(){
        x = Main.width/2;
        y = Main.height/2;
    }
    
    public boolean collision(double x2, double y2, double radius2){
        double xDif = (x-radius/2) - (x2-radius2/2);
        double yDif = (y-radius/2) - (y2-radius2/2);
        double distanceSquared = xDif * xDif + yDif * yDif;
        return distanceSquared < (radius/2 + radius2/2) * (radius/2 + radius2/2);
    }
    

    @Override
    public void mouseDragged(MouseEvent me) {
        x = me.getX()- radius / 2;
        y = me.getY()- radius / 2;
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        x = me.getX()- radius / 2;
        y = me.getY()- radius / 2;
    }
    
    public void render(Graphics g){
        g.setColor(Color.green);
        g.fillOval((int)x, (int)y, (int)radius, (int)radius);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if(me.getButton() == MouseEvent.BUTTON1){
            leftPressed = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(me.getButton() == MouseEvent.BUTTON1){
            leftPressed = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    public double getMouseX(){return x + radius/2;}
    public double getMouseY(){return y + radius/2;}
    public boolean getLeftPressed(){return leftPressed;}
}
