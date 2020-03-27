package model;

import processing.core.PApplet;

public class Jugador {

    private PApplet app;
    private Tanque tanque;
    private String nombre;
    private int vida;

    public Jugador(PApplet app){
        this.app=app;
        this.vida=3;
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

    public void setVida(int vida) {
        this.vida = vida;
    }
}
