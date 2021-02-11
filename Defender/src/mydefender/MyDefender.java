/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydefender;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import static java.util.Collections.list;

import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.D;
import static javafx.scene.input.KeyCode.SPACE;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.util.Duration; 


import javafx.stage.Stage;


import javafx.stage.Stage;

/**
 *
 * @author florie
 * @author theot
 */
public class MyDefender extends Application {
    private double time = 0; 
    Timer loop;
    int nSkin = 0;
    ArrayList<HumanSpaceCraft> humans = new ArrayList();
    ArrayList<AlienShot> alienShot = new ArrayList();
    ArrayList<HumanShot> humanShot = new ArrayList();
    int noHuman = 0;
    private boolean dansMenu = false;
    @Override
    public void start(Stage primaryStage) throws MalformedURLException, IOException, InterruptedException {

        
        
        /*Création d'un canvas*/
        Parent rootMenu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene sceneMenu = new Scene(rootMenu, 1000, 600);
        Parent rootControles = FXMLLoader.load(getClass().getResource("Controles.fxml"));
        Scene sceneControles = new Scene(rootControles, 1000, 600);
        Parent rootRegles = FXMLLoader.load(getClass().getResource("Regles.fxml"));
        Scene sceneRegles = new Scene(rootRegles, 1000, 600);
        
        ArrayList<Image> alienSkin = new ArrayList<Image>();
        ArrayList<Image> humanSkin = new ArrayList<Image>();
        
                 
        Group aGroup = new Group(); 
        Scene aScene = new Scene(aGroup, 990, 600); 
        
        Canvas aCanvas = new Canvas(600, 600);
        aGroup.getChildren().add(aCanvas); 
        File file1 = new File("././rss/alienSkin1.png"); 
        String localUrl1 = file1.toURI().toURL().toString(); 
        Image alienSkin1 = new Image(localUrl1);
        alienSkin.add(alienSkin1);
        
        File file2 = new File("././rss/alienSkin2.png"); 
        String localUrl2 = file2.toURI().toURL().toString(); 
        Image alienSkin2 = new Image(localUrl2); 
        alienSkin.add(alienSkin2);
        
        File file3 = new File("././rss/alienSkin3.png"); 
        String localUrl3 = file3.toURI().toURL().toString(); 
        Image alienSkin3 = new Image(localUrl3); 
        alienSkin.add(alienSkin3);
        
        
        File file4 = new File("././rss/humanSkin1.png"); 
        String localUrl4 = file4.toURI().toURL().toString(); 
        Image humanSkin1 = new Image(localUrl4);
        humanSkin.add(humanSkin1);
        
        File file5 = new File("././rss/humanSkin2.png"); 
        String localUrl5 = file5.toURI().toURL().toString(); 
        Image humanSkin2 = new Image(localUrl5);
        humanSkin.add(humanSkin2);
        
        File file6 = new File("././rss/humanSkin3.png"); 
        String localUrl6 = file6.toURI().toURL().toString(); 
        Image humanSkin3 = new Image(localUrl6);
        humanSkin.add(humanSkin3);
        
        File file7 = new File("././rss/explosion.png"); 
        String localUrl7 = file7.toURI().toURL().toString(); 
        Image explosion = new Image(localUrl7);
       
        AlienSpaceCraft alienSpaceCraft = new AlienSpaceCraft(50, 300, 90, 30, Color.YELLOW);
        HumanSpaceCraft humanSpaceCraft = new HumanSpaceCraft(800, -100, 100, 40, Color.GREEN, 0);
        HumanSpaceCraft humanSpaceCraft2 = new HumanSpaceCraft(800, -100, 100, 40, Color.GREEN, 0);
        HumanSpaceCraft humanSpaceCraft3 = new HumanSpaceCraft(500, -100, 100, 40, Color.GREEN, 0);
        HumanSpaceCraft humanSpaceCraft4 = new HumanSpaceCraft(500, -100, 100, 40, Color.GREEN, 0);
        HumanSpaceCraft humanSpaceCraft5 = new HumanSpaceCraft(500, -100, 100, 40, Color.GREEN, 0);
        HumanSpaceCraft humanSpaceCraft6 = new HumanSpaceCraft(500, -100, 100, 40, Color.GREEN, 0);
        
        humans.add(humanSpaceCraft);
        humans.add(humanSpaceCraft2);
        humans.add(humanSpaceCraft3);
        humans.add(humanSpaceCraft4);
        humans.add(humanSpaceCraft5);
        humans.add(humanSpaceCraft6);
        
        alienSpaceCraft.setFill(new ImagePattern(alienSkin1));
        humanSpaceCraft.setFill(new ImagePattern(humanSkin1));
        humanSpaceCraft2.setFill(new ImagePattern(humanSkin1));
        humanSpaceCraft3.setFill(new ImagePattern(humanSkin1));
        humanSpaceCraft4.setFill(new ImagePattern(humanSkin1));
        humanSpaceCraft5.setFill(new ImagePattern(humanSkin1));
        humanSpaceCraft6.setFill(new ImagePattern(humanSkin1));
        
        Image background = new Image("file:././rss/fond.png");
        ImageView bg = new ImageView();
        bg.setImage(background);
        aGroup.getChildren().add(bg);
        bg.setFitWidth(1000);
        bg.setFitHeight(600);
        
        Game game = new Game();
        
        Label Annoncescore = new Label();
        Annoncescore.setText("Score :");
        Annoncescore.setTranslateX(470);
        
        Label nbrPoints = new Label();
        
        nbrPoints.setTranslateX(510);
        
       /* nbrPoints.setText(game.getScore()); */
        
        
        
        /*nbrPoints.textProperty().bind(game.getScore().asString());*/
        
        
        aGroup.getChildren().add(Annoncescore); 
        aGroup.getChildren().add(nbrPoints);
        
        aGroup.getChildren().add(alienSpaceCraft); 
        aGroup.getChildren().add(humanSpaceCraft); 
        aGroup.getChildren().add(humanSpaceCraft2); 
        aGroup.getChildren().add(humanSpaceCraft3); 
        aGroup.getChildren().add(humanSpaceCraft4); 
        aGroup.getChildren().add(humanSpaceCraft5); 
        aGroup.getChildren().add(humanSpaceCraft6);
        
        //Tir ennemi temporaire//
        HumanShot tirHumain =  new HumanShot(humanSpaceCraft, alienSpaceCraft, 20, 5, Color.RED); 
        humanShot.add(tirHumain);
        aGroup.getChildren().add(tirHumain); 
        
        HumanShot tirHumain2 =  new HumanShot(humanSpaceCraft2, alienSpaceCraft, 20, 5, Color.RED); 
        humanShot.add(tirHumain2);
        aGroup.getChildren().add(tirHumain2); 
        
        HumanShot tirHumain3 =  new HumanShot(humanSpaceCraft3, alienSpaceCraft, 20, 5, Color.RED); 
        humanShot.add(tirHumain3);
        aGroup.getChildren().add(tirHumain3); 
        
        HumanShot tirHumain4 =  new HumanShot(humanSpaceCraft4, alienSpaceCraft, 20, 5, Color.RED); 
        humanShot.add(tirHumain4);
        aGroup.getChildren().add(tirHumain4); 
        
        HumanShot tirHumain5 =  new HumanShot(humanSpaceCraft5, alienSpaceCraft, 20, 5, Color.RED); 
        humanShot.add(tirHumain5);
        aGroup.getChildren().add(tirHumain5); 
        
        HumanShot tirHumain6 =  new HumanShot(humanSpaceCraft6, alienSpaceCraft, 20, 5, Color.RED); 
        humanShot.add(tirHumain6);
        aGroup.getChildren().add(tirHumain6); 

        
        
        GraphicsContext aGraphicsContext = aCanvas.getGraphicsContext2D(); 
        
       
        
     
       
        
        primaryStage.setTitle("My Defender");
        primaryStage.setScene(aScene);
        
        
        
        
       
      aScene.setOnKeyPressed(new EventHandler <KeyEvent>()
        {
            @Override
            public void handle (KeyEvent event){
            if (event.getCode().toString().toUpperCase().equals("Z")){
                alienSpaceCraft.moveUp();
            }
            if (event.getCode().toString().toUpperCase().equals("S")){
                alienSpaceCraft.moveDown();
            }
            if(event.getCode().toString().toUpperCase().equals("SPACE")){
                AlienShot tirAlien =  new AlienShot(alienSpaceCraft, 20, 5, Color.LIGHTGREEN, 25); 
                alienShot.add(tirAlien);
                aGroup.getChildren().add(tirAlien); 
            }
            if (event.getCode().toString().toUpperCase().equals("ESCAPE")) {
                primaryStage.setScene(sceneMenu);
                dansMenu = true;
            }
            if (event.getCode().toString().toUpperCase().equals("C")) {
                primaryStage.setScene(sceneControles);
                dansMenu = true;
            }
            if (event.getCode().toString().toUpperCase().equals("R")) {
                primaryStage.setScene(sceneRegles);
                dansMenu = true;
            }
        } 
        });
      sceneMenu.setOnKeyPressed(new EventHandler <KeyEvent>()
        {
            @Override
            public void handle (KeyEvent event){
            if (event.getCode().toString().toUpperCase().equals("ESCAPE")) {
                primaryStage.setScene(aScene);
                dansMenu = false;
            }
            if (event.getCode().toString().toUpperCase().equals("C")) {
                primaryStage.setScene(sceneControles);
            }
            if (event.getCode().toString().toUpperCase().equals("R")) {
                primaryStage.setScene(sceneRegles);
            }
        } 
        });
       
       sceneControles.setOnKeyPressed(new EventHandler <KeyEvent>()
        {
            @Override
            public void handle (KeyEvent event){
            if (event.getCode().toString().toUpperCase().equals("ESCAPE")) {
                primaryStage.setScene(sceneMenu);
            }
        } 
        });
       
       sceneRegles.setOnKeyPressed(new EventHandler <KeyEvent>()
        {
            @Override
            public void handle (KeyEvent event){
            if (event.getCode().toString().toUpperCase().equals("ESCAPE")) {
                primaryStage.setScene(sceneMenu);
            }
        } 
        });




       loop = new Timer();
       
       
       //Boucle d'appartion des vaisseaux humains
       TimerTask humanSpawn = new TimerTask(){
           @Override
            public void run() {
                if(noHuman <= 5){
                    humans.get(noHuman).setSpeed(-3);
                    humans.get(noHuman).setTranslateX(1000);
                    humans.get(noHuman).setTranslateY((int)(Math.random() * 500 + 50));
                    humans.get(noHuman).setDead(false);
                    humans.get(noHuman).setInGame(true);
                    noHuman ++;
                }
            }
       };
       
       loop.schedule(humanSpawn, 1000, 8000);
       
       
       
       
       //Boucle du mouvement des vaisseau humain
       TimerTask humanMovement = new TimerTask(){
           @Override
            public void run() {
                 for(HumanSpaceCraft s : humans){
                     if(s.isDead() == true){
                         s.setTranslateX(1000);
                         s.setTranslateY((int)(Math.random() * 500 + 50));
                         s.setFill(new ImagePattern(humanSkin1));
                         s.setDead(false);
                     }
                     s.move();
                     if(s.getTranslateX()< 0){
                         s.setTranslateX(1000);
                         s.setTranslateY((int)(Math.random() * 500 + 50));
                         game.setScore(game.getScore() - 500);
                     }
                 }
            }
       };
       
        loop.schedule(humanMovement, 1000, 100);
        
        
        
        
        
        //Boucle du mouvement des tirs du joueurs
        TimerTask alienShotMovement = new TimerTask(){
           @Override
            public void run() {
                 for(AlienShot s : alienShot){
                     s.move();
                     if(s.getTranslateX()> 1000){
                         s.setxSpeed(0);
                         s.setTranslateY(-100);
                         s.setTranslateX(100);
                     }
                     for(HumanSpaceCraft a : humans){
                         if(s.getTranslateX() < a.getTranslateX() + 25 && s.getTranslateX() > a.getTranslateX() - 25 && s.getTranslateY() < a.getTranslateY() + 40 && s.getTranslateY() > a.getTranslateY() - 40 && a.isDead() == false){
                            game.setScore(game.getScore()+100);
                            System.out.println(game.getScore());
                            s.setxSpeed(0);
                            s.setTranslateX(100);
                            s.setTranslateY(-100);
                            a.setDead(true);
                            a.setFill(new ImagePattern(explosion));
                         }
                     
                    }  
                 }
            }
       };
       
        loop.schedule(alienShotMovement, 1000, 100);
        
        
        //Boucle de tirs des vaisseaux ennemis
        TimerTask humanShoot = new TimerTask(){
           @Override
            public void run() {
                 for(HumanSpaceCraft s : humans){
                     if(s.isInGame()){
                         int probabilityOfShoot = (int) (Math.random() * ( 3 ));
                         if(probabilityOfShoot == 1){
                             for(HumanShot h : humanShot){
                                 if(h.getTireur() == s && !h.isInGame()){
                                     h.setTranslateX(s.getTranslateX()-20);
                                     h.setTranslateY(s.getTranslateY()+20);
                                     h.setxSpeed();
                                     h.setySpeed();
                                     h.setInGame(true);
                                 }
                             }
                         }
                       }  
                 }
                 
            }
       };
        
        loop.schedule(humanShoot, 1000, 5000);
        
        
        
        //Boucle du mouvement des tirs des ennemis
        TimerTask humanShotMovement = new TimerTask(){
           @Override
            public void run() {
                 for(HumanShot s : humanShot){
                     if(s.isInGame() == true){
                        s.move();
                        if(s.getTranslateX()< -100){
                            s.setxSpeed(0);
                            s.setySpeed(0);
                            s.setTranslateY(-100);
                            s.setTranslateX(100);
                            s.setInGame(false);
                        }
                            if(s.getTranslateX() < alienSpaceCraft.getTranslateX() + 35 && s.getTranslateX() > alienSpaceCraft.getTranslateX() - 35 && s.getTranslateY() < alienSpaceCraft.getTranslateY() + 20 && s.getTranslateY() > alienSpaceCraft.getTranslateY() - 20){
                               System.out.println("Une vie en moins");
                               s.setxSpeed(0);
                               s.setySpeed(0);
                               s.setTranslateX(100);
                               s.setTranslateY(-100);
                               s.setInGame(false);
                               alienSpaceCraft.looseALife();
                               if(alienSpaceCraft.getNbLife() == -1){
                                   loop.cancel();
                                   System.out.println("Perdu, votre score est de : " + game.getScore());
                               }
                            
                            }
                       }  
                 }
            }
       };
        
        loop.schedule(humanShotMovement, 1000, 100);
            
        
        //Boucle du changement d'apparence des vaisseaux
        TimerTask skinTimer = new TimerTask(){
           @Override
            public void run() {
                nSkin ++;
                if(nSkin == 3){
                    nSkin = 0;
                }
                alienSpaceCraft.setFill(new ImagePattern(alienSkin.get(nSkin)));
                
                for(HumanSpaceCraft s : humans){
                    if(s.isDead() == false)
                     s.setFill(new ImagePattern(humanSkin.get(nSkin)));
                 }
            }
       };
        
        loop.schedule(skinTimer, 1000, 250);

        

        
        primaryStage.setResizable(false);
        
        
        
        primaryStage.show();
        
        
        }
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
        public void stop(){
        loop.cancel();
        }

}



