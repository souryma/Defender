/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydefender;

import javafx.scene.paint.Color;

/**
 *
 * @author florie
 */

public class HumanShot extends Bullet {
    private int ySpeed;
    private boolean inGame;
    private AlienSpaceCraft vaisseauViser;

    public HumanShot(SpaceCraft vaisseauTireur, AlienSpaceCraft vaisseauAlien, int w, int h, Color color) {
        super(vaisseauTireur.getTranslateX()-20, vaisseauTireur.getTranslateY()+20, w, h, color);
        
        this.vaisseauViser = vaisseauAlien;
        
        double humainX = vaisseauTireur.getTranslateX();
        double humainY = vaisseauTireur.getTranslateY();
        double alienX = vaisseauAlien.getTranslateX();
        double alienY = vaisseauAlien.getTranslateY();
        
        double variationX = alienX - humainX;
        double variationY = alienY - humainY;
        double vitesseX = variationX % 10 + 15;
        double vitesseY = vitesseX * variationY / variationX;
        
        this.xSpeed = 0;
        this.ySpeed = 0;
        
        this.tireur = vaisseauTireur;
        this.inGame = false;
        
        this.setTranslateX(800);
        this.setTranslateY(-100);
    }
    
    @Override
    public void move () {
        this.setTranslateX(getTranslateX() + this.xSpeed);
        this.setTranslateY(getTranslateY() + this.ySpeed);
    }
    
    public void setySpeed() {
        double humainX = this.tireur.getTranslateX();
        double humainY = this.tireur.getTranslateY();
        double alienX = this.vaisseauViser.getTranslateX();
        double alienY = vaisseauViser.getTranslateY();
        
        double variationX = alienX - humainX;
        double variationY = alienY - humainY;
        double vitesseX = variationX % 10 + 15;
        double vitesseY = vitesseX * variationY / variationX;
        
        this.ySpeed = (int) ((int) - vitesseY*25/vitesseX);
    }
    
    public void setxSpeed() {
        this.xSpeed = -25;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }
    
    
    
    
}


