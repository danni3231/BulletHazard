package com.parrotgames.bullethazardcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;

public class ControlActivity extends AppCompatActivity implements OnMessageListener {

    private ComunicacionTCP comm;
    private Button btnUp;
    private Button btnDown;
    private Button btnShoot;
    private boolean pressUp;
    private boolean pressDown;

    @SuppressLint({"SourceLockedOrientationActivity", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        pressUp=true;
        pressDown=true;

        comm = ComunicacionTCP.getInstance();
        btnUp=findViewById(R.id.btnUp);
        btnDown=findViewById(R.id.btnDown);
        btnShoot=findViewById(R.id.btnShoot);

        btnUp.setOnTouchListener(
                (v, event)->{
                    switch(event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            pressUp=false;
                            break;

                        case MotionEvent.ACTION_UP:
                            pressUp=true;
                            break;
                    }
                    return true;
                }
        );

        new Thread(
                ()->{
                    while(true){
                        while(pressUp){}
                        try {
                            Thread.sleep(25);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        comm.mandarMensaje("Game,UP");
                    }
                }
        ).start();

        btnDown.setOnTouchListener(
                (v, event)->{
                    switch(event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            pressDown=false;
                            break;

                        case MotionEvent.ACTION_UP:
                            pressDown=true;
                            break;
                    }
                    return true;
                }
        );

        new Thread(
                ()->{
                    while(true){
                        while(pressDown){}
                        try {
                            Thread.sleep(25);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        comm.mandarMensaje("Game,DOWN");
                    }
                }
        ).start();

        btnShoot.setOnClickListener(
                (v)->{
                    comm.mandarMensaje("Game,SHOOT");
                }
        );
    }

    @Override
    public void onMessage(String message) {
        if(message.equals("Game over")){
            Intent activity = new Intent(ControlActivity.this,ResumenActivity.class);
            startActivity(activity);
        }
    }
}
