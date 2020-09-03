package com.example.rapha.kita_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by Rapha on 30.12.2017.
 */

public class Veranst_Rueckmeld_Select extends AppCompatActivity {

    Button home;
    Button sommerfest;

    Bundle received = new Bundle();
    Bundle sending = new Bundle();
    String message;
    Intent startHome;
    Intent startSommerfest;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veranst_rueckmeld_select);

        received = getIntent().getExtras();
        message = received.getString("user");

        home = (Button) findViewById(R.id.button1);
        sommerfest = (Button) findViewById(R.id.button2);

        sending.putString("user", message);

        startHome = new Intent(Veranst_Rueckmeld_Select.this, Home.class);
        startHome.putExtras(sending);

        startSommerfest = new Intent(Veranst_Rueckmeld_Select.this, Veranst_Rueckmeld_Smr.class);
        startSommerfest.putExtras(sending);

        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(startHome);
            }
        });

        sommerfest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(startSommerfest);
            }
        });
    }
}
