/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydefender;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;



/**
 *
 * @author florie
 */
public abstract class SpaceCraft extends Rectangle{
    
    boolean dead = true; 
    
    
    SpaceCraft(int x, int y, int w, int h, Color color)
    {
        super(w, h, color); 
        setTranslateX(x); 
        setTranslateY(y); 
    }
    
    public abstract void moveUp();
    
    public abstract void moveDown();
    
    public abstract void move();
    
}
