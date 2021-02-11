/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydefender;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author florie
 * @author theot
 */
public abstract class Bullet extends Rectangle{
    
    protected SpaceCraft tireur;
    protected int xSpeed;
    
    Bullet(double x, double y, int w, int h, Color color)
    {
        super(w, h, color); 
        setTranslateX(x); 
        setTranslateY(y);
    }
    
    public abstract void move();
    
    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public SpaceCraft getTireur() {
        return tireur;
    }
    
    
    
}












