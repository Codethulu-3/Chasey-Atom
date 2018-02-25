package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Alex
 */
public class Charge {
    
    private double x,y;
    private double vx, vy;
    private double oldvx, oldvy;
    private double ax, ay;
    private double charge;
    
    private double radius;
    
    public Charge(double x, double y, double charge){
        this.x = x;
        this.y = y;
        this.charge = charge;
        radius = 10;
    }
    
    public void update(){
        vx = oldvx + (ax/2);
        vy = oldvy + (ay/2);
        
        x+=vx;
        y+=vy;
        
        if(x<=0 || x>= Main.width){
            vx *= -1;
        }
        if(y<=0 || y>= Main.height){
            vy *= -1;
        }
        
        
        oldvx = vx;
        oldvy = vy;
    }
    
    public void render(Graphics g){
        if(charge<0){
            g.setColor(Color.yellow);
        } else {
            g.setColor(Color.blue);
        }
        g.fillOval((int)x, (int)y, (int)10, (int)10);
    }
    
    //getters and setters
    public double getCharge(){return charge;}
    public void setAx(double ax){this.ax = ax;}
    public void setAy(double ay){this.ay = ay;}
    public double getX(){return x;}
    public double getY(){return y;}
    public void setX(double x){this.x = x;}
    public void setY(double y){this.y = y;}
    public double getRadius(){return radius;}
}
