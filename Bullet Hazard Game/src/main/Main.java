package main;

import comm.ComunicacionTCP;
import comm.OnMessageListener;
import model.Logica;
import processing.core.PApplet;
import view.*;


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
    Escenario escenario;

    public void settings() {
        size(1200, 700);
    }

    public void setup() {
        rectMode(CENTER);
        imageMode(CENTER);
        textAlign(CENTER);

        pantallas=0;
        celOk=false;
        datos1 = new String[2];
        datos2 = new String[2];

        comm = new ComunicacionTCP();
        comm.esperarConexion(this);

        logica = new Logica(this);
        inicio = new Inicio(this);
        instrucciones = new Instrucciones(this);
        conexion = new Conexion(this);
        seleccion = new Seleccion(this);
        escenario = new Escenario(this);
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
                    try{
                        logica.crearJugadores(datos1, datos2);
                    } catch (NumberFormatException e) {
                        printArray(datos1);
                        printArray(datos2);
                    }
                    pantallas=seleccion.cambiarPantalla();
                }

                break;
            case 4:
                escenario.setJugadores(logica.getJugadores());
                escenario.pintar();
                logica.pintar();
                logica.validarChoque();
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
        switch (pantallas) {
            case 3:
                if (!seleccion.isListo()) {
                    seleccion.getInput().writeText(key);
                }
                break;
            case 4:
                logica.moverjugador1(keyCode);
                break;
        }

    }

    public void onMessage(String message) {
        System.out.println(message);
        if(message.startsWith("Datos")){
            String[] splitText =message.split(",");
            datos2[0]=splitText[1];
            datos2[1]=splitText[2];
            celOk=true;
            printArray(splitText);
        }
        if(message.startsWith("Game")){
            String[] splitText =message.split(",");
            logica.moverJugador2(splitText[1]);
        }

    }
}
