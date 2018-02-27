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
    private double mass;
    
    public static final double vmax=0.8;
    
    private double radius;
    
    public Charge(double x, double y, double charge, double mass){
        this.x = x;
        this.y = y;
        this.charge = charge;
        this.mass = mass;
        radius = 10;
    }
    
    public void update(){
        vx = oldvx + (ax);
        vy = oldvy + (ay);
        
        x+=vx;
        y+=vy;
        
        if(x<=0 || x>= Main.width - radius){
            vx *= -1;
        }
        if(y<=0 || y>= Main.height - radius){
            vy *= -1;
        }
        
        if(vx > vmax){
            vx = vmax;
        }
        if(vy > vmax){
            vy = vmax;
        }
        if(vx<-vmax){
            vx = -vmax;
        }
        if(vy<-vmax){
            vy = -vmax;
        }
        
        oldvx = vx;
        oldvy = vy;
    }
    
    public boolean collision(double x2, double y2, double radius2){
        double xDif = (x-radius/2) - (x2-radius2/2);
        double yDif = (y-radius/2) - (y2-radius2/2);
        double distanceSquared = xDif * xDif + yDif * yDif;
        return distanceSquared < (radius/2 + radius2/2) * (radius/2 + radius2/2);
    }
    
    public void render(Graphics g){
        if(charge<0){
            g.setColor(Color.yellow);
        } else if(charge>0){
            g.setColor(Color.blue);
        } else {
            g.setColor(Color.gray);
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
    public double getVX(){return vx;}
    public double getVY(){return vy;}
    public void setVX(double vx){this.vx = vx;}
    public void setVY(double vy){this.vy = vy;}
    public double getRadius(){return radius;}
    public double getMass(){return mass;}
}
