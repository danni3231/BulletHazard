package model;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Tanque {

    private PApplet app;
    private ArrayList<Bala> balas;
    private int index;
    private int numeroBalas;
    private int posX;
    private int posY;
    private int vel;
    private PImage img;
    private PImage imgBala;

    public Tanque(int posX,int posY,int index,PImage img,PApplet app){
        this.balas= new ArrayList<Bala>();
        this.index=index;
        this.numeroBalas=0;
        this.posX=posX;
        this.posY=posY;
        this.img=img;
        this.vel=5;
        this.app=app;
    }

    public void pintar(){
        app.image(img,posX,posY);
        reload();
        for(int i=0;i< balas.size();i++){
            balas.get(i).pintar();
            balas.get(i).mover(index);
            switch (index){
                case 1:
                    if(balas.get(i).getPosX()>1220){
                        balas.remove(i);
                    }
                    break;
                case 2:
                    if(balas.get(i).getPosX()<-20){
                        balas.remove(i);
                    }
                    break;
            }
        }
    }

    public void mover(String dir){
        if(dir.equals("UP") && posY>190){
            posY-=vel;
        }
        if(dir.equals("DOWN") && posY<625){
            posY+=vel;
        }
        if(dir.equals("SHOOT")){
            disparar();
        }
    }

    public void reload(){
        if(numeroBalas>3 && app.frameCount%120==0) {
            numeroBalas=0;
        }
    }

    public void disparar(){
        if (numeroBalas<=3){
            switch (index){
                case 1:
                    balas.add(new Bala(posX+50,posY, imgBala,app));
                    numeroBalas++;
                    break;
                case 2:
                    balas.add(new Bala(posX-50,posY, imgBala,app));
                    numeroBalas++;
                    break;
            }
        }
    }

    public void setImgBala(PImage imgBala) {
        this.imgBala = imgBala;
    }

    public ArrayList<Bala> getBalas() {
        return balas;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
