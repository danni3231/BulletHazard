package view;

import model.Jugador;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

public class Escenario {

    private PApplet app;
    private PImage fondo;
    private PImage[] corazones;
    private PFont trade;

    private Jugador[] jugadores;

    public Escenario(PApplet app){
        this.app=app;
        loadFonts();
        loadImages();
    }

    public void loadImages(){
        corazones = new PImage[2];

        fondo= app.loadImage("./data/fondo.png");
        for(int i=0; i<corazones.length;i++){
            corazones[i]= app.loadImage("./data/corazon"+i+".png");
        }
    }

    public void loadFonts(){
        trade = app.createFont("./data/TradeWinds-Regular.ttf",36);
    }

    public void pintar(){
        app.image(fondo,1200/2,700/2);
        app.fill(254,0,176);
        app.textFont(trade);
        app.textAlign(app.CENTER);
        app.text("VS",1200/2,70);
        app.fill(12,245,116);
        app.textAlign(app.LEFT);
        app.text(jugadores[0].getNombre(),60,70);
        app.textAlign(app.RIGHT);
        app.text(jugadores[1].getNombre(),1140,70);

        int corazonX1= (jugadores[0].getNombre().length()*20)+90;

        for(int i=0; i<4;i++){
            app.image(corazones[1],corazonX1+(i*40),60);
        }
        for(int i=0; i<jugadores[0].getVida();i++){
            app.image(corazones[0],corazonX1+(i*40),60);
        }

        int corazonX2= (jugadores[1].getNombre().length()*20)+90;

        for(int i=0; i<4;i++){
            app.image(corazones[1],1200-corazonX2-(i*40),60);
        }

        for(int i=0; i<jugadores[1].getVida();i++){
            app.image(corazones[0],1200-corazonX2-(i*40),60);
        }

    }
/*
    public int cambiarPantalla(){

    }
*/
    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }
}
