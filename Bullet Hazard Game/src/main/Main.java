package main;

import comm.ComunicacionTCP;
import comm.OnMessageListener;
import model.Logica;
import processing.core.PApplet;
import view.Conexion;
import view.Inicio;
import view.Instrucciones;
import view.Seleccion;


public class Main extends PApplet implements OnMessageListener {

    public static void main(String[] args) {
        PApplet.main("main.Main");
    }

    ComunicacionTCP comm;
    Logica logica;
    int pantallas;
    boolean celOk;
    String[] datos1;
    String[] datos2;

    Inicio inicio;
    Instrucciones instrucciones;
    Conexion conexion;
    Seleccion seleccion;

    public void settings() {
        size(1200, 700);
    }

    public void setup() {
        rectMode(CENTER);
        imageMode(CENTER);
        textAlign(CENTER);

        pantallas=3;
        celOk=true;
        datos1 = new String[2];
        datos2 = new String[2];

        comm = new ComunicacionTCP();
        comm.esperarConexion(this);

        logica = new Logica(this);
        inicio = new Inicio(this);
        instrucciones = new Instrucciones(this);
        conexion = new Conexion(this);
        seleccion = new Seleccion(this);
    }

    public void draw() {
        background(200);
       // System.out.println(pantallas);
        switch (pantallas) {
            case 0:
                inicio.pintar();
                pantallas = inicio.cambiarPantalla();
                break;
            case 1:
                instrucciones.pintar();
                break;
            case 2:
                conexion.setIp(logica.obtenerIp());
                conexion.pintar();
                conexion.setConectado(comm.isConectado());
                break;
            case 3:
                seleccion.pintar();
                if(seleccion.isListo() && celOk){
                    datos1 = seleccion.setDatos();
                    logica.crearJugadores(datos1, datos2);
                    pantallas=seleccion.cambiarPantalla();
                }

                break;
            case 4:
                logica.pintar();
                break;
        }

    }

    public void mousePressed(){
        switch (pantallas){
            case 0:
                break;
            case 1:
                pantallas=instrucciones.cambiarPantalla();
                break;
            case 2:
                pantallas=conexion.cambiarPantalla();
                break;
            case 3:
                seleccion.getInput().setFocus();
                seleccion.selecionar();
                break;
        }
    }

    public void keyPressed(){
        if(pantallas==3 && !seleccion.isListo()){
            seleccion.getInput().writeText(key);
        }
    }

    public void onMessage(String message) {

    }
}
