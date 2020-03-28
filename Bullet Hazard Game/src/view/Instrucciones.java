package view;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Instrucciones {
    private PApplet app;
    private Button boton;
    private PImage fondo;
    private PImage instruciones;
    private PFont trade;
    private PFont poppins;


    public Instrucciones(PApplet app){
        this.app=app;
        this.boton= new Button(1200/2,620,"Continuar",app);
        boton.setSize(200,40);
        boton.setColor(254,0,176);
        boton.setTextColor(255);
        loadImages();
        loadFonts();
    }

    public void loadImages(){
        fondo= app.loadImage("/data/fondo.png");
        instruciones = app.loadImage("/data/instrucciones.png");
    }

    public void loadFonts(){
        trade = app.createFont("/data/TradeWinds-Regular.ttf",48);
        poppins = app.createFont("/data/Poppins-Regular.ttf",18);
    }

    public void pintar(){
        app.image(fondo,1200/2,700/2);
        app.fill(254,0,176);
        app.textFont(trade);
        app.text("instrucciones",1200/2,85);
        app.image(instruciones,1200/2,350);
        app.textFont(poppins);
        boton.draw();
    }

    public int cambiarPantalla(){
        if(boton.over()){
            return 2;
        }
        return 1;
    }
}
