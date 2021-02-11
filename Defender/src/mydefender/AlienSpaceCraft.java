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
public class AlienSpaceCraft extends SpaceCraft {
    double leI = getTranslateY();
    
    int nbLife;
    
    
    public AlienSpaceCraft(int x, int y, int w, int h, Color color) {
        super(x, y, w, h, color);
        this.nbLife = 3;
    }
    
    public void moveUp() {
        if(leI != 30){
            setTranslateY(getTranslateY() - 5);
            leI -= 5;
        }
    }
    
    public void moveDown() {
        if(leI != 570){
            setTranslateY(getTranslateY() + 5);
            leI += 5;
        }
    }
    
    public void looseALife(){
        this.nbLife -=1;
    }

    public int getNbLife() {
        return nbLife;
    }
    
    

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
