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
public class HumanSpaceCraft extends SpaceCraft {

    private int speed;
    private boolean inGame;
    private boolean Shooting;
    
    public HumanSpaceCraft(int x, int y, int w, int h, Color color, int speed) {
        super(x, y, w, h, color);
        this.speed = speed;
        this.dead = true;
    }
    
    public void move() {
        this.setTranslateX(getTranslateX() + speed);
    }

    @Override
    public void moveUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isInGame() {
        return inGame;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isShooting() {
        return Shooting;
    }

    public void setShooting(boolean isShooting) {
        this.Shooting = isShooting;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }
    
    
    
}
