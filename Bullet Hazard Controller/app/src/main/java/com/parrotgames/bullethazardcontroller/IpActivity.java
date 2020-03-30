package com.parrotgames.bullethazardcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                    if(textIP.getText().toString().equals("")){
                        Toast.makeText(this,"Por favor escribe la IP",Toast.LENGTH_LONG).show();
                    }else{

                        Intent activity = new Intent(IpActivity.this,SelecionarActivity.class);
                        activity.putExtra("IP",textIP.getText().toString());
                        startActivity(activity);
                    }

                }
        );
    }
}
