package com.parrotgames.bullethazardcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class IpActivity extends AppCompatActivity {

    private Button btnEnviarIP;
    private EditText textIP;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip);

        btnEnviarIP = findViewById(R.id.btnEnviarIP);
        textIP = findViewById(R.id.textIP);

        btnEnviarIP.setOnClickListener(
                (v)->{
                    Intent activity = new Intent(IpActivity.this,SelecionarActivity.class);
                    activity.putExtra("IP",textIP.getText().toString());
                    startActivity(activity);
                }
        );
    }
}
