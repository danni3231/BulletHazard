package model;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Tanque {

    private PApplet app;
    private ArrayList<Bala> balas;
    private int index;
    private int posX;
    private int posY;
    private int vel;
    private PImage img;
    private PImage imgBala;

    public Tanque(int posX,int posY,int index,PImage img,PApplet app){
        this.balas= new ArrayList<Bala>();
        this.index=index;
        this.posX=posX;
        this.posY=posY;
        this.img=img;
        this.vel=5;
        this.app=app;
    }

    public void pintar(){
        app.image(img,posX,posY);
        for(int i=0;i< balas.size();i++){
            balas.get(i).pintar();
            balas.get(i).mover(index);
        }
    }

    public void mover(String dir){
        if(dir.equals("UP")){
            posY-=vel;
        }
        if(dir.equals("DOWN")){
            posY+=vel;
        }
        if(dir.equals("SHOOT")){
            disparar();
        }
    }
    public void disparar(){
        balas.add(new Bala(posX,posY, imgBala,app));
    }

    public void setImgBala(PImage imgBala) {
        this.imgBala = imgBala;
    }
}
