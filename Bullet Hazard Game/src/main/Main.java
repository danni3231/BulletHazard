package main;

import comm.ComunicacionTCP;
import comm.OnMessageListener;
import model.Logica;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import view.Inicio;
import view.Instrucciones;

public class Main extends PApplet implements OnMessageListener {


    public static void main(String[] args) {
        PApplet.main("main.Main");
    }

    ComunicacionTCP comm;
    Logica logica;
    int pantallas;
    Inicio inicio;
    Instrucciones instrucciones;

    public void settings() {
        size(1200, 700);
    }

    public void setup() {
        rectMode(CENTER);
        imageMode(CENTER);
        textAlign(CENTER);

        comm = new ComunicacionTCP();
        comm.esperarConexion(this);
        logica = new Logica(this);
        inicio = new Inicio(this);
        instrucciones = new Instrucciones(this);

        String[] datos1 = new String[2];
        String[] datos2 = new String[2];
        datos1[0] = "yolo";
        datos2[0] = "carlos";
        datos1[1] = "1";
        datos2[1] = "3";

        logica.crearJugadores(datos1, datos2);
    }

    public void draw() {
        background(200);
        // logica.pintar();
        System.out.println(pantallas);
        switch (pantallas) {
            case 0:
                inicio.pintar();
                pantallas = inicio.cambiarPantalla();

                break;
            case 1:
                instrucciones.pintar();
        }

    }

    public void mousePressed(){
        switch (pantallas){
            case 0:
                break;
            case 1:
                pantallas=instrucciones.cambiarPantalla();
                break;
        }
    }

    public void onMessage(String message) {

    }
}
