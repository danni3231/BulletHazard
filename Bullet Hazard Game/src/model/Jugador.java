package model;

import processing.core.PApplet;

import java.util.ArrayList;

public class Jugador {

    private PApplet app;
    private Tanque tanque;
    private String nombre;
    private int vida;

    public Jugador(PApplet app){
        this.app=app;
        this.vida=4;
    }

    public void choque(ArrayList<Bala> bala){
        for(int i=0; i<bala.size();i++){
            int d= (int) app.dist(tanque.getPosX(),tanque.getPosY(),bala.get(i).getPosX(),bala.get(i).getPosY());
            if(d<50){
                bala.remove(i);
                restarVida();
                System.out.println(vida);
            }
        }
    }

    public void restarVida(){
        vida-=1;
    }

    public Tanque getTanque() {
        return tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

}
