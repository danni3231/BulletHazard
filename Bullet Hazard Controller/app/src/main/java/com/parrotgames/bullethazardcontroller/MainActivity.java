package com.parrotgames.bullethazardcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar=findViewById(R.id.btnIniciarM);

        btnIniciar.setOnClickListener(
                (v)->{
                    Intent IP = new Intent(MainActivity.this,IpActivity.class);
                    startActivity(IP);
                }
        );
    }
}
