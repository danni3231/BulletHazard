package view;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Conexion {
    private PApplet app;
    private String ip;
    private Button boton;
    private PImage fondo;
    private PImage cuadro;
    private PFont trade;
    private PFont poppins;
    private boolean conectado;


    public Conexion(PApplet app){
        this.app=app;
        this.conectado=false;
        this.boton= new Button(1200/2,550,"Esperando",app);
        boton.setSize(200,40);
        boton.setColor(254,0,176);
        boton.setTextColor(255);
        loadImages();
        loadFonts();
    }

    public void loadImages(){
        fondo= app.loadImage("./data/fondo.png");
        cuadro = app.loadImage("./data/cuadro.png");
    }

    public void loadFonts(){
        trade = app.createFont("./data/TradeWinds-Regular.ttf",48);
        poppins = app.createFont("./data/Poppins-Regular.ttf",40);
    }

    public void pintar(){
        app.image(fondo,1200/2,700/2);
        app.fill(254,0,176);
        app.textFont(trade);
        app.text("Conexión",1200/2,160);
        app.textFont(poppins);
        app.textSize(20);
        app.fill(255);
        app.text("Para poder usar tu celular como control\n "+
                "por favor conectate con tu IP:",1200/2,300);
        app.textSize(35);
        app.fill(12,245,116);
        app.text(ip,1200/2,400);
        app.textSize(18);
        boton.draw();
        if(!conectado){
            if(boton.getText().equals("Esperando...")){
                if(app.frameCount%30==0){
                    boton.setText("Esperando");
                }
            }else{
                if(app.frameCount%60==0){
                    boton.setText(boton.getText()+".");
                }
            }

        }else{
            boton.setText("Listo!");
        }
    }

    public int cambiarPantalla(){
        if(boton.over() && conectado){
            return 3;
        }
        return 2;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
}
