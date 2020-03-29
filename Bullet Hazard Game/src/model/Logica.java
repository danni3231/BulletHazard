package model;

import processing.core.PApplet;
import processing.core.PImage;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Clock;

import static java.lang.Integer.parseInt;

public class Logica {

    private PApplet app;
    private Jugador[] jugadores;
    private InetAddress address;

    //imagenes//
    private PImage[] imgTanquesPreview;
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
        this.imgTanques=new PImage[4];
        this.imgTanquesPreview=new PImage[4];

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

    public void crearJugadores(String[] datos1, String[] datos2) throws NumberFormatException{
        jugadores[0]= new Jugador(app);
        jugadores[0].setNombre(datos1[0]);
        Tanque tanque1 = new Tanque(50,150,imgTanques[parseInt(datos1[1])],app);
        jugadores[0].setTanque(tanque1);

        jugadores[1]= new Jugador(app);
        jugadores[1].setNombre(datos2[0]);
        Tanque tanque2 = new Tanque(1000,150,imgTanques[parseInt(datos2[1])],app);
        jugadores[1].setTanque(tanque2);

        System.out.println(jugadores[0].getNombre());
        System.out.println(jugadores[1].getNombre());
    }
}
