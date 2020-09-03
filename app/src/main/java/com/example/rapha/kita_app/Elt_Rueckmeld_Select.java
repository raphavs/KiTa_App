package com.example.rapha.kita_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by Rapha on 29.12.2017.
 */

public class Elt_Rueckmeld_Select extends AppCompatActivity {

    Button home;
    Button ea;
    Button eg;

    Bundle received = new Bundle();
    Bundle sending = new Bundle();
    String message;
    Intent startHome;
    Intent startEA;
    Intent startEG;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elt_rueckmeld_select);

        received = getIntent().getExtras();
        message = received.getString("user");

        home = (Button) findViewById(R.id.button1);
        ea = (Button) findViewById(R.id.button2);
        eg = (Button) findViewById(R.id.button3);

        sending.putString("user", message);

        startHome = new Intent(Elt_Rueckmeld_Select.this, Home.class);
        startHome.putExtras(sending);

        startEA = new Intent(Elt_Rueckmeld_Select.this, Elt_Rueckmeld_EA.class);
        startEA.putExtras(sending);

        startEG = new Intent(Elt_Rueckmeld_Select.this, Elt_Rueckmeld_EG.class);
        startEG.putExtras(sending);

        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(startHome);
            }
        });

        ea.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(startEA);
            }
        });

        eg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(startEG);
            }
        });
    }
}
