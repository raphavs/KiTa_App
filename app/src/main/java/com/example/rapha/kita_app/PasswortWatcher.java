package com.example.rapha.kita_app;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by Rapha on 27.12.2017.
 */

public class PasswortWatcher implements TextWatcher {

    private EditText edit;

    public PasswortWatcher(EditText et){
        this.edit = et;
    }

    private String correctPasswort;
    String passwort;

    public String getCorrectPasswort(){
        return this.correctPasswort;
    }
    public void setCorrectPasswort(String passwort){
        this.correctPasswort = passwort;
    }

    @Override
    public void beforeTextChanged (CharSequence s, int start, int count, int after){
    }
    @Override
    public void onTextChanged (CharSequence s, int start, int before, int count){
        passwort = edit.getText().toString();
    }
    @Override
    public void afterTextChanged (Editable s){
        setCorrectPasswort(passwort);
    }
}
