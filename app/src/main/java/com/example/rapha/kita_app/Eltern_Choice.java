package com.example.rapha.kita_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Rapha on 29.12.2017.
 */

public class Eltern_Choice extends AppCompatActivity {

    Button home;
    Button gespraech;
    Button abend;
    Button teilnahme;

    Bundle received = new Bundle();
    Bundle sending = new Bundle();
    String message;
    Intent startHome;
    Intent startAbend;
    Intent startGespraech;
    Intent startTeilnahme;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eltern_choice);

        received = getIntent().getExtras();
        message = received.getString("user");

        home = (Button) findViewById(R.id.button3);
        abend = (Button) findViewById(R.id.button1);
        gespraech = (Button) findViewById(R.id.button2);
        teilnahme = (Button) findViewById(R.id.button4);

        sending.putString("user", message);

        startHome = new Intent(Eltern_Choice.this, Home.class);
        startHome.putExtras(sending);

        startAbend = new Intent(Eltern_Choice.this, Elternabend_Select.class);
        startAbend.putExtras(sending);

        startGespraech = new Intent(Eltern_Choice.this, Elterngespraech_Select.class);
        startGespraech.putExtras(sending);

        startTeilnahme = new Intent(Eltern_Choice.this, Elt_Rueckmeld_Select.class);
        startTeilnahme.putExtras(sending);

        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(startHome);
            }
        });

        abend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(startAbend);
            }
        });

        gespraech.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(startGespraech);
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
