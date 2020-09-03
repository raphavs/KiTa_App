package com.example.rapha.kita_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rapha on 29.12.2017.
 */

public class Elterngespraech_Ext extends AppCompatActivity {

    TextView empfaenger;
    Button home;
    Button versenden;

    Intent startHome;
    Bundle received = new Bundle();
    Bundle sendingHome = new Bundle();
    String message;
    String kinder;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elterngespraech_ext);

        received = getIntent().getExtras();
        message = received.getString("user");
        kinder = received.getString("selection");

        home = (Button) findViewById(R.id.button1);
        versenden = (Button) findViewById(R.id.button2);
        empfaenger = (TextView) findViewById(R.id.textView2);
        empfaenger.setText("Empfänger:\n" + kinder);

        startHome = new Intent(Elterngespraech_Ext.this, Home.class);
        sendingHome.putString("user", message);
        startHome.putExtras(sendingHome);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(startHome);
            }
        });

        versenden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Elterngespraech_Ext.this, "Erfolgreich an die Eltern versendet!", Toast.LENGTH_LONG).show();
                startActivity(startHome);
            }
        });
    }
}
