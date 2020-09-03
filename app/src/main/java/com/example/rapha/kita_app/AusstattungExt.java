package com.example.rapha.kita_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Rapha on 28.12.2017.
 */

public class AusstattungExt extends AppCompatActivity {

    TextView kinderView;
    Button home;
    Button bestätigen;

    Intent startHome;
    Bundle received = new Bundle();
    Bundle sendingHome = new Bundle();
    String message;
    String kinder;

    ArrayList<String> selection = new ArrayList<String>();
    int counter = 0;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ausstattung_ext);

        received = getIntent().getExtras();
        message = received.getString("user");
        kinder = received.getString("selection");

        home = (Button) findViewById(R.id.button1);
        bestätigen = (Button) findViewById(R.id.button2);
        kinderView = (TextView) findViewById(R.id.textView2);
        kinderView.setText(kinder);

        startHome = new Intent(AusstattungExt.this, Home.class);
        sendingHome.putString("user", message);
        startHome.putExtras(sendingHome);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(startHome);
            }
        });

        bestätigen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == 0){
                    Toast.makeText(AusstattungExt.this, "Bitte treffen Sie eine Auswahl!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AusstattungExt.this, "Erfolgreich an die Eltern versendet!", Toast.LENGTH_LONG).show();
                    startActivity(startHome);
                }
            }
        });
    }

    public void selectElement(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.checkBox1:
                if(checked){
                    counter += 1;
                } else {
                    counter -= 1;
                }
                break;
            case R.id.checkBox2:
                if(checked){
                    counter += 1;
                } else {
                    counter -= 1;
                }
                break;
            case R.id.checkBox3:
                if(checked){
                    counter += 1;
                } else {
                    counter -= 1;
                }
                break;
            case R.id.checkBox4:
                if(checked){
                    counter += 1;
                } else {
                    counter -= 1;
                }
                break;
            case R.id.checkBox5:
                if(checked){
                    counter += 1;
                } else {
                    counter -= 1;
                }
                break;
            case R.id.checkBox6:
                if(checked){
                    counter += 1;
                } else {
                    counter -= 1;
                }
                break;
            case R.id.checkBox7:
                if(checked){
                    counter += 1;
                } else {
                    counter -= 1;
                }
                break;
            case R.id.checkBox8:
                if(checked){
                    counter += 1;
                } else {
                    counter -= 1;
                }
                break;
            case R.id.checkBox9:
                if(checked){
                    counter += 1;
                } else {
                    counter -= 1;
                }
                break;
        }
    }
}