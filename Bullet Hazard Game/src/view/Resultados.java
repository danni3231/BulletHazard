package view;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

public class Resultados {

    private PApplet app;
    private PImage fondo;
    private PFont trade;
    private String ganador;

    public Resultados(PApplet app){
        this.app=app;
        loadImages();
        loadFonts();
    }

    public void loadImages(){
        fondo= app.loadImage("./data/fondo.png");
    }

    public void loadFonts(){
        trade = app.createFont("./data/TradeWinds-Regular.ttf",55);
    }

    public void pintar(){
        app.image(fondo,1200/2,700/2);
        app.fill(254,0,176);
        app.textFont(trade);
        app.textAlign(app.CENTER);
        app.text("El ganador es:",1200/2,330);
        app.textSize(45);
        app.fill(12,245,116);
        app.text(ganador,1200/2,380);
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }
}
