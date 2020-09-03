package com.example.rapha.kita_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Rapha on 30.12.2017.
 */

public class Veranst_Rueckmeld_Smr extends AppCompatActivity {

    Button home;

    Bundle received = new Bundle();
    Bundle sendingHome = new Bundle();
    String message;
    Intent startHome;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veranst_rueckmeld_smr);

        received = getIntent().getExtras();
        message = received.getString("user");

        home = (Button) findViewById(R.id.button1);

        startHome = new Intent(Veranst_Rueckmeld_Smr.this, Home.class);
        sendingHome.putString("user", message);
        startHome.putExtras(sendingHome);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(startHome);
            }
        });
    }
}
