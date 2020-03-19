package com.parrotgames.bullethazardcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SelecionarActivity extends AppCompatActivity implements OnMessageListener {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar);

        String ip = getIntent().getExtras().getString("IP");
        ComunicacionTCP comm = new ComunicacionTCP(this);
        comm.solicitarConexion( ip );
    }

    public void onMessage(String message) {

    }
}
