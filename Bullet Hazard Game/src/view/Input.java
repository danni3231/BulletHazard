package view;

import processing.core.PApplet;

public class Input {

    private int posX;
    private int posY;
    private int width;
    private int height;
    private int index;
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

    public Input(int posX, int posY, int index, PApplet app){
        this.posX=posX;
        this.posY=posY;
        this.index=index;
        this.text="";
        this.app=app;

        this.colorMode=0;
        this.color=200;

        this.textColorMode =0;
        this.textColor =0;
    }

    public void draw(){
        app.noStroke();

        switch (colorMode){
            case 0:
                if(focus){
                    app.fill(color-20);
                }else{
                    app.fill(color);
                }
                break;
            case 1:
                if(focus){
                    app.fill(r-20,g-20,b-20);
                }else{
                    app.fill(r,g,b);
                }
                break;
        }
        app.rect(posX,posY,width,height,height/2);

        switch (index){
            case 0:
                displayText();
                break;

            case 1:
                displayPassword();
                break;
        }

    }

    public void setSize( int width, int height){
        this.width=width;
        this.height=height;
    }

    public void setFocus(){
        focus= app.mouseX > posX-(width/2) && app.mouseX < posX+(width/2) &&
                app.mouseY > posY-(height/2) && app.mouseY < posY+(width/2);
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
        textColor =color;
        textColorMode =0;
    }

    public void setTextColor(int r, int g, int b){
        textR =r;
        textG =g;
        textB =b;
        textColorMode =1;
    }

    public void displayText() {
        if(textColorMode ==0){
            app.fill(textColor);
        }else{
            app.fill(textR, textG, textB);
        }

        app.textSize(16);
        app.text(text,this.posX,this.posY+(height/8));
    }

    public void displayPassword() {
        String codeSecure = "";

        for (int i = 0; i < text.length(); i++) {
            codeSecure += "*";
        }
        if(textColorMode ==0){
            app.fill(textColor);
        }else{
            app.fill(textR, textG, textB);
        }

        app.textSize(16);
        app.text(codeSecure,this.posX,this.posY+(height/8));
    }

    public void writeText(char key) {
        if (focus) {
            if (key!=8){
                text += key;
            }else{
                int indice = text.length() - 1;
                try{
                    text = text.substring(0, indice);
                } catch (StringIndexOutOfBoundsException e) {
                    //
                }
            }
        }
    }

    public String getText() {
        return text;
    }

}
