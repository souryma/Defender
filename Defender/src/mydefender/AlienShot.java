/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydefender;

import javafx.scene.paint.Color;

/**
 *
 * @author theot
 */
public class AlienShot extends Bullet {

    public AlienShot(SpaceCraft vaisseauTireur, int w, int h, Color color, int xSpeed) {
        super(vaisseauTireur.getTranslateX()+40, vaisseauTireur.getTranslateY()+20, w, h, color);
        this.xSpeed = xSpeed;
        this.tireur = vaisseauTireur;
    }
    
    @Override
    public void move () {
        setTranslateX(getTranslateX() + this.xSpeed);
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }
    
    
    
}
    
