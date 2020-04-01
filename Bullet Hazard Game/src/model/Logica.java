package model;

import processing.core.PApplet;
import processing.core.PImage;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Logica {

    private PApplet app;
    private Jugador[] jugadores;
    private InetAddress address;

    //imagenes//
    private PImage[] imgTanques;
    private PImage imgBala;

    public Logica(PApplet app){
        this.app=app;
        this.jugadores= new Jugador[2];
        loadImages();
    }

    public void pintar(){
        jugadores[0].getTanque().pintar();
        jugadores[1].getTanque().pintar();
    }

    public void loadImages(){
        this.imgTanques=new PImage[8];

        for(int i=0; i < imgTanques.length;i++){
            imgTanques[i]=app.loadImage("/data/tanque"+i+".png");
        }
        imgBala= app.loadImage("bala.png");
    }

    public String obtenerIp(){
        try {
            address = InetAddress.getLocalHost();
            return address.getHostAddress();
        } catch (UnknownHostException e) {
            return "No se obtuvo la ip";
        }
    }

    public void moverjugador1(int key){
        if(key == 38){
            jugadores[0].getTanque().mover("UP");
        }
        if(key == 40){
            jugadores[0].getTanque().mover("DOWN");
        }
        if(key == 32){
            jugadores[0].getTanque().mover("SHOOT");
        }
    }

    public void moverJugador2(String dir){
        jugadores[1].getTanque().mover(dir);
    }

    public void crearJugadores(String[] datos1, String[] datos2) throws NumberFormatException{
        jugadores[0]= new Jugador(app);
        jugadores[0].setNombre(datos1[0]);
        Tanque tanque1 = new Tanque(125,300,1,imgTanques[parseInt(datos1[1])],app);
        jugadores[0].setTanque(tanque1);
        jugadores[0].getTanque().setImgBala(imgBala);

        jugadores[1]= new Jugador(app);
        jugadores[1].setNombre(datos2[0]);
        Tanque tanque2 = new Tanque(1075,300,2,imgTanques[parseInt(datos2[1])],app);
        jugadores[1].setTanque(tanque2);
        jugadores[1].getTanque().setImgBala(imgBala);

        System.out.println(jugadores[0].getNombre());
        System.out.println(jugadores[1].getNombre());
    }

    public void validarChoque(){
        jugadores[0].choque(jugadores[1].getTanque().getBalas());
        jugadores[1].choque(jugadores[0].getTanque().getBalas());
    }

    public int validarGameOver(){
        if (jugadores[0].getVida()==0 || jugadores[1].getVida()==0){
            return 5;
        }
        return 4;
    }

    public String ganador(){
        if(jugadores[0].getVida()>0){
            return jugadores[0].getNombre();
        }else if (jugadores[1].getVida()>0){
            return jugadores[1].getNombre();
        }
        return null;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }
}
