package view;

import processing.core.PApplet;
import processing.core.PImage;

public class Inicio {

    private PApplet app;
    private PImage fondo;
    private PImage logo;

    public Inicio(PApplet app){
        this.app=app;
        loadImages();
    }

    public void loadImages(){
        fondo= app.loadImage("./data/fondo.png");
        logo= app.loadImage("./data/logo.png");
    }

    public void pintar(){
        app.image(fondo,1200/2,700/2);
        app.image(logo,1200/2,700/2);
    }

    public int cambiarPantalla(){
        if(app.frameCount%180==0){
            return 1;
        }
        return 0;
    }


}
