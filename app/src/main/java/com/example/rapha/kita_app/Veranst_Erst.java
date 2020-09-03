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
 * Created by Rapha on 29.12.2017.
 */

public class Veranst_Erst extends AppCompatActivity {

    Button home;
    Button bestätigen;

    Intent startHome;
    Intent startVeranstaltungenExt;
    Bundle received = new Bundle();
    Bundle sendingHome = new Bundle();
    Bundle sendingExt = new Bundle();
    String message;

    ArrayList<String> selection = new ArrayList<String>();

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veranst_erst);

        received = getIntent().getExtras();
        message = received.getString("user");

        home = (Button) findViewById(R.id.button1);
        bestätigen = (Button) findViewById(R.id.button2);

        startHome = new Intent(Veranst_Erst.this, Home.class);
        sendingHome.putString("user", message);
        startHome.putExtras(sendingHome);

        startVeranstaltungenExt = new Intent(Veranst_Erst.this, Veranst_Erst_Ext.class);

        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(startHome);
            }
        });

        bestätigen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(selection.size() == 0){
                    Toast.makeText(Veranst_Erst.this, "Bitte treffen Sie eine Auswahl!", Toast.LENGTH_LONG).show();
                } else {
                    sendingExt.putString("user", message);
                    sendingExt.putString("selection", finalSelection());
                    startVeranstaltungenExt.putExtras(sendingExt);
                    startActivity(startVeranstaltungenExt);
                }
            }
        });
    }

    public void selectItem (View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.checkBox1:
                if(checked){
                    selection.add("Ballakow, Paul");
                } else {
                    selection.remove("Ballakow, Paul");
                }
                break;
            case R.id.checkBox2:
                if(checked){
                    selection.add("Chiurazzi, Antonella");
                } else {
                    selection.remove("Chiurazzi, Antonella");
                }
                break;
            case R.id.checkBox3:
                if(checked){
                    selection.add("Dold, Lea-Sophie");
                } else {
                    selection.remove("Dold, Lea-Sophie");
                }
                break;
            case R.id.checkBox4:
                if(checked){
                    selection.add("Griese, Jan");
                } else {
                    selection.remove("Griese, Jan");
                }
                break;
            case R.id.checkBox5:
                if(checked){
                    selection.add("Leone, Lara");
                } else {
                    selection.remove("Leone, Lara");
                }
                break;
            case R.id.checkBox6:
                if(checked){
                    selection.add("Mandel, Luca");
                } else {
                    selection.remove("Mandel, Luca");
                }
                break;
            case R.id.checkBox7:
                if(checked){
                    selection.add("Nowara, Rebekka");
                } else {
                    selection.remove("Nowara, Rebekka");
                }
                break;
            case R.id.checkBox8:
                if(checked){
                    selection.add("Reuter, Dominik");
                } else {
                    selection.remove("Reuter, Dominik");
                }
                break;
            case R.id.checkBox9:
                if(checked){
                    selection.add("Schwarz, Liam");
                } else {
                    selection.remove("Schwarz, Liam");
                }
                break;
            case R.id.checkBox10:
                if(checked){
                    selection.add("Steig, Evan");
                } else {
                    selection.remove("Steig, Evan");
                }
                break;
            case R.id.checkBox19:
                if(checked){
                    selection.add("yallah");
                } else {
                    selection.remove("yallah");
                }
                break;
        }
    }

    public String finalSelection (){
        String selected = "";
        for (String selections : selection) {
            selected = selected + selections + "\n";
            if(selections.equals("yallah")){
                return "Alle Kinder";
            }
        }
        return selected;
    }
}
