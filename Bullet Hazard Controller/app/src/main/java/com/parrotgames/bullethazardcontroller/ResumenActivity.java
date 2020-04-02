package com.parrotgames.bullethazardcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResumenActivity extends AppCompatActivity implements OnMessageListener {

    private ComunicacionTCP comm;
    private String nombre;
    private TextView textNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        nombre=getIntent().getExtras().getString("NAME");

        comm = ComunicacionTCP.getInstance();
        comm.setObserver(this);

        textNombre = findViewById(R.id.textNameR);
        textNombre.setText(nombre);


    }

    @Override
    public void onMessage(String message) {

    }
}
