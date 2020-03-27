package main;

import comm.ComunicacionTCP;
import comm.OnMessageListener;
import model.Logica;
import processing.core.PApplet;

public class Main extends PApplet implements OnMessageListener {


    public static void main(String[] args) {
        PApplet.main("main.Main");
    }

    ComunicacionTCP comm;
    Logica logica;

    public void settings(){
        size(1200,700);
    }
    public void setup(){
        comm = new ComunicacionTCP();
        comm.esperarConexion(this);
        logica = new Logica(this);
        logica.loadImage();
    }

    public void draw(){
        //background(200);
    }

    public void onMessage(String message) {

    }
}
