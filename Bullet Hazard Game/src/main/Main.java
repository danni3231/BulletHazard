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

        String[] datos1= new String[2];
        String[] datos2= new String[2];
        datos1[0]="yolo";
        datos2[0]="carlos";
        datos1[1]="1";
        datos2[1]="r";

        logica.crearJugadores(datos1,datos2);
    }

    public void draw(){
        background(200);
        logica.draw();
    }

    public void onMessage(String message) {

    }
}
