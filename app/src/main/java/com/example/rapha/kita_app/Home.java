package com.example.rapha.kita_app;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Rapha on 27.12.2017.
 */

public class Home extends AppCompatActivity {

    TextView username;
    Button ausstattung;
    Button veranstaltungen;
    Button eltern;
    Button ausloggen;
    TextView logo;

    String message;
    Bundle received = new Bundle();
    Bundle sending = new Bundle();
    Intent startAusstattung;
    Intent startVeranstaltungen;
    Intent startEltern;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        received = getIntent().getExtras();
        message = received.getString("user");

        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "ANTQUAB.TTF");
        username = (TextView) findViewById(R.id.textView1);
        ausstattung = (Button) findViewById(R.id.button1);
        veranstaltungen = (Button) findViewById(R.id.button2);
        eltern = (Button) findViewById(R.id.button3);
        ausloggen = (Button) findViewById(R.id.button4);
        logo = (TextView) findViewById(R.id.textView2);
        logo.setTypeface(myTypeface);
        username.setText("Hallo " + message + "!");

        sending.putString("user", message);

        startAusstattung = new Intent(Home.this, Ausstattung.class);
        startAusstattung.putExtras(sending);

        startVeranstaltungen = new Intent(Home.this, Veranstaltungen_Choice.class);
        startVeranstaltungen.putExtras(sending);

        startEltern = new Intent(Home.this, Eltern_Choice.class);
        startEltern.putExtras(sending);

        ausstattung.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(startAusstattung);
            }
        });

        veranstaltungen.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(startVeranstaltungen);
            }
        });

        eltern.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(startEltern);
            }
        });

        ausloggen.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(new Intent(Home.this, ActivityOne.class));
            }
        });
    }
}
