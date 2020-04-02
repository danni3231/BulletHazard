package view;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Instrucciones {

    private PApplet app;
    private String texto;
    private PImage fondo;
    private PImage instrucionesCel;
    private PImage instrucionesPC;
    private PFont trade;
    private PFont poppins;

    public Instrucciones(PApplet app){
        this.app=app;
        this.texto="Tu objetivo es acabar con las cuatro vidas de tu oponente antes de que\n" +
                "él haga lo propio con las tuyas. Usando los controles en tu móvil o del\n" +
                "teclado de tu PC, deberás mover tu tanque para esquivar los proyectiles\n" +
                "que lance tu oponente y disparar para asestar un golpe mortífero que\n" +
                "acabe con la vida de tu oponente. ";
        loadImages();
        loadFonts();
    }

    public void loadImages(){
        fondo= app.loadImage("./data/fondo.png");
        instrucionesPC = app.loadImage("./data/instrucciones pc.png");
        instrucionesCel = app.loadImage("./data/instrucciones cel.png");
    }

    public void loadFonts(){
        trade = app.createFont("./data/TradeWinds-Regular.ttf",48);
        poppins = app.createFont("./data/Poppins-Regular.ttf",24);
    }

    public void pintar(){
        app.image(fondo,1200/2,700/2);
        app.fill(254,0,176);
        app.textFont(trade);
        app.text("Instrucciones",1200/2,100);
        app.textFont(poppins);
        app.fill(255);
        app.textLeading(35);
        app.textSize(20);
        app.text(texto,1200/2,180);
        app.image(instrucionesPC,300,520);
        app.image(instrucionesCel,900,520);
    }

    public int cambiarPantalla(){
        return 2;
    }
}
