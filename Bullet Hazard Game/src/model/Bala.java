package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Bala {

    private PApplet app;
    private int posX;
    private int posY;
    private int vel;
    private PImage img;

    public Bala(int posX,int posY,PImage img,PApplet app){
        this.posX=posX;
        this.posY=posY;
        this.vel=8;
        this.app=app;
        this.img=img;
    }

    public void pintar(){
        app.image(img,posX,posY);
    }

    public void mover(int jugador){
        if(jugador==1){
            this.posX+=10;
        }
        if(jugador==2){
            this.posX-=10;
        }

    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
