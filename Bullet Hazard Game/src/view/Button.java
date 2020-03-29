package view;

import processing.core.PApplet;

public class Button {

    private int posX;
    private int posY;
    private int width;
    private int height;
    private String text;
    private boolean focus;
    private PApplet app;

    private int colorMode;
    private int color;
    private int r;
    private int g;
    private int b;

    private int textColorMode;
    private int textColor;
    private int textR;
    private int textG;
    private int textB;

    public Button(int posX, int posY, String text, PApplet app){
        this.posX=posX;
        this.posY=posY;
        this.text=text;
        this.app=app;
        this.colorMode=0;
        this.color=200;
        this.textColorMode =0;
        this.textColor=0;
    }

    public void setSize( int width, int height){
        this.width=width;
        this.height=height;
    }

    public void draw(){
        app.noStroke();
        switch (colorMode){
            case 0:
                if(focus){
                    app.fill(color-40);
                }else{
                    app.fill(color);
                }
                break;
            case 1:
                if(focus){
                    app.fill(r-40,g-40,b-40);
                }else{
                    app.fill(r,g,b);
                }
                break;
        }
        setFocus();
        app.rect(posX,posY,width,height,height/2);
        switch (textColorMode){
            case 0:
                app.fill(textColor);
                break;
            case 1:
                app.fill(textR, textG, textB);
                break;
        }
        app.text(text,this.posX,this.posY+(height/8));
    }

    public void setColor(int color){
        this.color =color;
        colorMode=0;
    }

    public void setColor(int r, int g, int b){
        this.r=r;
        this.g=g;
        this.b=b;
        colorMode=1;
    }

    public void setTextColor(int color){
        textColor=color;
        textColorMode =0;
    }

    public void setTextColor(int r, int g, int b){
        textR =r;
        textG =g;
        textB =b;
        textColorMode =1;
    }

    public boolean over(){
        return app.mouseX > posX-(width/2) && app.mouseX < posX+(width/2) &&
                app.mouseY > posY-(height/2) && app.mouseY < posY+(width/2);
    }

    public void setFocus(){
        focus= app.mouseX > posX-(width/2) && app.mouseX < posX+(width/2) &&
                app.mouseY > posY-(height/2) && app.mouseY < posY+(width/2);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
