package model;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Tanque {

    private PApplet app;
    private ArrayList<Bala> balas;
    private int posX;
    private int posY;
    private int vel;
    private PImage img;

    public Tanque(int posX, int posY, PImage img,PApplet app){
        this.balas= new ArrayList<Bala>();
        this.posX=posX;
        this.posY=posY;
        this.img=img;
        this.vel=5;
        this.app=app;
    }

    public void pintar(){
        app.image(img,posX,posY);
    }
    public void mover(String dir){
        if(dir.equals("UP")){
            posY-=vel;
        }
        if(dir.equals("DOWN")){
            posY+=vel;
        }
    }
    public void disparar(){


    }
}
