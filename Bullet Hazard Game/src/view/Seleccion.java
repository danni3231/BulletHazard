package view;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Seleccion {
    private PApplet app;
    private Button boton;
    private Input input;
    private boolean listo;
    private PImage fondo;
    private PImage[] preview;
    private PFont trade;
    private PFont poppins;
    private String indexTanque;


    public Seleccion(PApplet app){
        this.app=app;
        this.indexTanque=null;
        this.boton = new Button(1200/2,620,"Seleccionar",app);
        boton.setSize(200,40);
        boton.setColor(254,0,176);
        boton.setTextColor(255);

        this.input = new Input(1200/2,533,0,app);
        input.setSize(350,40);
        input.setColor(255);
        input.setTextColor(254,0,176);

        loadImages();
        loadFonts();
    }

    public void loadImages(){
        preview = new PImage[4];

        fondo= app.loadImage("./data/fondo.png");
        for(int i=0; i<preview.length;i++){
            preview[i] = app.loadImage("./data/preview"+i+".png");
        }
    }

    public void loadFonts(){
        trade = app.createFont("./data/TradeWinds-Regular.ttf",48);
        poppins = app.createFont("./data/Poppins-Regular.ttf",18);
    }

    public void pintar(){
        app.image(fondo,1200/2,700/2);
        app.fill(254,0,176);
        app.textFont(trade);
        app.text("Selecciona tu tanque",1200/2,85);
        for(int i=0; i<preview.length;i++){
            app.image(preview[i],222+(i*252),310);
            if (indexTanque!=null){
                app.image(preview[Integer.parseInt(indexTanque)],222+(Integer.parseInt(indexTanque)*252),310);
            }
        }
        app.textFont(poppins);
        boton.draw();
        input.draw();

    }

    public void selecionar(){
        if(boton.over() && indexTanque!=null && getInput().getText() != ""){
            listo=true;
            boton.setText("Listo!");
        }
        for(int i=0; i<preview.length;i++){
            if(app.mouseX>(222+(i*252))-101 && app.mouseX<(222+(i*252))+101 &&
                    app.mouseY>310-130 && app.mouseY<310+130){
                indexTanque=String.valueOf(i);
            }
        }
    }

    public int cambiarPantalla(){
        return 4;
    }

    public String[] setDatos(){
        String[] datos = new String[2];
        datos[0] = input.getText();
        datos[1] = indexTanque;
        return datos;
    }
    public Input getInput() {
        return input;
    }

    public boolean isListo() {
        return listo;
    }
}
