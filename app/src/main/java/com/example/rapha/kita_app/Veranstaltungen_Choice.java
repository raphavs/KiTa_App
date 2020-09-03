package com.example.rapha.kita_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Rapha on 30.12.2017.
 */

public class Veranstaltungen_Choice extends AppCompatActivity {

    Button home;
    Button erstellen;
    Button teilnahme;

    Bundle received = new Bundle();
    Bundle sending = new Bundle();
    String message;
    Intent startHome;
    Intent startErstellen;
    Intent startTeilnahme;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veranstaltungen_choice);

        received = getIntent().getExtras();
        message = received.getString("user");

        home = (Button) findViewById(R.id.button3);
        erstellen = (Button) findViewById(R.id.button1);
        teilnahme = (Button) findViewById(R.id.button2);

        sending.putString("user", message);

        startHome = new Intent(Veranstaltungen_Choice.this, Home.class);
        startHome.putExtras(sending);

        startErstellen = new Intent(Veranstaltungen_Choice.this, Veranst_Erst.class);
        startErstellen.putExtras(sending);

        startTeilnahme = new Intent(Veranstaltungen_Choice.this, Veranst_Rueckmeld_Select.class);
        startTeilnahme.putExtras(sending);

        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(startHome);
            }
        });

        erstellen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(startErstellen);
            }
        });

        teilnahme.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(startTeilnahme);
            }
        });
    }
}
