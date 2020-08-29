package com.ugb.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    Button bt3Conversiones;
    Button bt4Conversiones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt3Conversiones=(Button)findViewById(R.id.bt3conversiones);
        bt3Conversiones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Conversores.class);
                startActivity(i);
            }
        });

        bt4Conversiones=(Button)findViewById(R.id.bt4conversiones);
        bt4Conversiones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Conversores2.class);
                startActivity(i);
            }
        });
    }







}