package com.parrotgames.bullethazardcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SelecionarActivity extends AppCompatActivity{

    private ComunicacionTCP comm;
    private String indexTanque;
    private Button btnPreview0;
    private Button btnPreview1;
    private Button btnPreview2;
    private Button btnPreview3;
    private Button btnSeleccionar;
    private EditText textNombre;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar);

        String ip = getIntent().getExtras().getString("IP");
        comm = ComunicacionTCP.getInstance();
        comm.solicitarConexion( ip );

        btnPreview0 = findViewById(R.id.btnPreview0);
        btnPreview1 = findViewById(R.id.btnPreview1);
        btnPreview2 = findViewById(R.id.btnPreview2);
        btnPreview3 = findViewById(R.id.btnPreview3);
        btnSeleccionar = findViewById(R.id.btnSeleccionar);
        textNombre = findViewById(R.id.textNombre);

        btnPreview0.setOnClickListener(
                (view)->{
                    Drawable btn0 = getResources().getDrawable(R.drawable.sel0);
                    Drawable btn1 = getResources().getDrawable(R.drawable.preview1);
                    Drawable btn2 = getResources().getDrawable(R.drawable.preview2);
                    Drawable btn3 = getResources().getDrawable(R.drawable.preview3);
                    btnPreview0.setBackground(btn0);
                    btnPreview1.setBackground(btn1);
                    btnPreview2.setBackground(btn2);
                    btnPreview3.setBackground(btn3);
                    indexTanque="4";
                }
        );

        btnPreview1.setOnClickListener(
                (view)->{
                    Drawable btn0 = getResources().getDrawable(R.drawable.preview0);
                    Drawable btn1 = getResources().getDrawable(R.drawable.sel1);
                    Drawable btn2 = getResources().getDrawable(R.drawable.preview2);
                    Drawable btn3 = getResources().getDrawable(R.drawable.preview3);
                    btnPreview0.setBackground(btn0);
                    btnPreview1.setBackground(btn1);
                    btnPreview2.setBackground(btn2);
                    btnPreview3.setBackground(btn3);
                    indexTanque="5";
                }
        );

        btnPreview2.setOnClickListener(
                (view)->{
                    Drawable btn0 = getResources().getDrawable(R.drawable.preview0);
                    Drawable btn1 = getResources().getDrawable(R.drawable.preview1);
                    Drawable btn2 = getResources().getDrawable(R.drawable.sel2);
                    Drawable btn3 = getResources().getDrawable(R.drawable.preview3);
                    btnPreview0.setBackground(btn0);
                    btnPreview1.setBackground(btn1);
                    btnPreview2.setBackground(btn2);
                    btnPreview3.setBackground(btn3);
                    indexTanque="6";
                }
        );

        btnPreview3.setOnClickListener(
                (view)->{
                    Drawable btn0 = getResources().getDrawable(R.drawable.preview0);
                    Drawable btn1 = getResources().getDrawable(R.drawable.preview1);
                    Drawable btn2 = getResources().getDrawable(R.drawable.preview2);
                    Drawable btn3 = getResources().getDrawable(R.drawable.sel3);
                    btnPreview0.setBackground(btn0);
                    btnPreview1.setBackground(btn1);
                    btnPreview2.setBackground(btn2);
                    btnPreview3.setBackground(btn3);
                    indexTanque="7";
                }
        );

        btnSeleccionar.setOnClickListener(
                (view)->{
                    if(textNombre.getText().toString().equals("")){
                        Toast.makeText(this,"Por favor escribe tu nombre y selecciona un tanque",Toast.LENGTH_LONG).show();
                    }else{
                        comm.mandarMensaje("Datos,"+textNombre.getText().toString()+","+indexTanque);
                        Intent activity = new Intent(SelecionarActivity.this,ControlActivity.class);
                        startActivity(activity);
                    }
                }
        );

    }

}
