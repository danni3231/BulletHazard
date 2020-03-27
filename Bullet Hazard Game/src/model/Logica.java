package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Logica {

    private PApplet app;
    private Jugador[] jugadores;
    private PImage[] imgTanques;
    private PImage imgBala;

    public Logica(PApplet app){
        this.app=app;
        this.jugadores= new Jugador[2];
        this.imgTanques=new PImage[4];
    }

    public void loadImage(){
        for(int i=0; i < imgTanques.length;i++){
            imgTanques[i]=app.loadImage("/data/tanque"+i+".png");
        }
        imgBala= app.loadImage("bala.png");
    }
}
