package com.parrotgames.bullethazardcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;

public class SelecionarActivity extends AppCompatActivity implements OnMessageListener {

    private ComunicacionTCP comm;
    private Button btnPreview0;
    private Button btnPreview1;
    private Button btnPreview2;
    private Button btnPreview3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar);

        btnPreview0 = findViewById(R.id.btnPreview0);
        btnPreview1 = findViewById(R.id.btnPreview1);
        btnPreview2 = findViewById(R.id.btnPreview2);
        btnPreview3 = findViewById(R.id.btnPreview3);

        String ip = getIntent().getExtras().getString("IP");
        comm = ComunicacionTCP.getInstance();
        comm.solicitarConexion( ip );

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
                }
        );

    }

    public void onMessage(String message) {

    }
}
