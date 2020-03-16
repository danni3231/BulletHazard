package main;

import comm.ComunicacionTCP;
import comm.OnMessageObserver;
import processing.core.PApplet;

public class Main extends PApplet implements OnMessageObserver {


    public static void main(String[] args) {
        PApplet.main("main.Main");
    }

    ComunicacionTCP comm;

    public void settings(){
        size(1000,600);
    }
    public void setup(){
        comm = new ComunicacionTCP();
        comm.esperarConexion(this);
    }

    public void draw(){
        background(200);
    }

    public void onMessage(String message) {

    }
}
