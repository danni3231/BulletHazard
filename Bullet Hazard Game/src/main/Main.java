package main;

import comm.ComunicacionTCP;
import comm.OnMessageListener;
import model.Logica;
import processing.core.PApplet;
import processing.core.PImage;
import view.Inicio;

public class Main extends PApplet implements OnMessageListener {


    public static void main(String[] args) {
        PApplet.main("main.Main");
    }

    ComunicacionTCP comm;
    Logica logica;
    int pantallas;
    Inicio inicio;

    public void settings(){
        size(1200,700);
    }
    public void setup(){
        imageMode(CENTER);

        comm = new ComunicacionTCP();
        comm.esperarConexion(this);
        logica = new Logica(this);
        inicio = new Inicio(this);

        String[] datos1= new String[2];
        String[] datos2= new String[2];
        datos1[0]="yolo";
        datos2[0]="carlos";
        datos1[1]="1";
        datos2[1]="3";

        logica.crearJugadores(datos1,datos2);
    }

    public void draw(){
        //  background(200);
        // logica.pintar();
        switch (pantallas){
            case 0:
                inicio.pintar();
                pantallas=inicio.cambiarPantalla();

                break;
            case 1:
                background(255);
                System.out.println(pantallas);
        }
        inicio.pintar();

    }

    public void onMessage(String message) {

    }
}
