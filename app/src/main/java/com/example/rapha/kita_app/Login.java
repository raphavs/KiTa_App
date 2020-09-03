package com.example.rapha.kita_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Rapha on 27.12.2017.
 */

public class Login extends AppCompatActivity {

    EditText editMail;
    TextView mailInkorrekt;
    EditText editPasswort;
    TextView passwortInkorrekt;
    Button abbrechen;
    Button einloggen;

    Intent myIntent;
    Bundle bundle = new Bundle();

    public boolean checkValidEMail(String mail){
        return mail.matches(".+@[a-zA-z].*\\.(de|info|org|com|net)");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editMail = (EditText) findViewById(R.id.editText1);
        mailInkorrekt = (TextView) findViewById(R.id.textView2);
        editPasswort = (EditText) findViewById(R.id.editText2);
        passwortInkorrekt = (TextView) findViewById(R.id.textView3);
        abbrechen = (Button) findViewById(R.id.button1);
        einloggen = (Button) findViewById(R.id.button2);

        final MailWatcher mailInsta = new MailWatcher(editMail);
        mailInsta.setCorrectMail("wrong");
        editMail.addTextChangedListener(mailInsta);

        final PasswortWatcher passwortInsta = new PasswortWatcher(editPasswort);
        passwortInsta.setCorrectPasswort("wrong");
        editPasswort.addTextChangedListener(passwortInsta);

        myIntent = new Intent(Login.this, Home.class);

        final String password = "7";

        einloggen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (password.equals(passwortInsta.getCorrectPasswort()) && !(checkValidEMail(mailInsta.getCorrectMail()))) {
                    mailInkorrekt.setVisibility(View.VISIBLE);
                    editMail.setText("", TextView.BufferType.EDITABLE);
                    passwortInkorrekt.setVisibility(View.INVISIBLE);
                } else if (checkValidEMail(mailInsta.getCorrectMail()) && !(password.equals(passwortInsta.getCorrectPasswort()))) {
                    passwortInkorrekt.setVisibility(View.VISIBLE);
                    editPasswort.setText("", TextView.BufferType.EDITABLE);
                    mailInkorrekt.setVisibility(View.INVISIBLE);
                } else if (checkValidEMail(mailInsta.getCorrectMail()) && password.equals(passwortInsta.getCorrectPasswort())) {
                    mailInkorrekt.setVisibility(View.INVISIBLE);
                    passwortInkorrekt.setVisibility(View.INVISIBLE);
                    android.os.SystemClock.sleep(1234);
                    bundle.putString("user", mailInsta.getCorrectMail());
                    myIntent.putExtras(bundle);
                    startActivity(myIntent);
                } else {
                    editMail.setText("", TextView.BufferType.EDITABLE);
                    editPasswort.setText("", TextView.BufferType.EDITABLE);
                    mailInkorrekt.setVisibility(View.VISIBLE);
                    passwortInkorrekt.setVisibility(View.VISIBLE);
                }
            }
        });

        abbrechen.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(new Intent(Login.this, ActivityOne.class));
            }
        });
    }
}