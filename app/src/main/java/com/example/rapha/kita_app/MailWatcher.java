package com.example.rapha.kita_app;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by Rapha on 27.12.2017.
 */

public class MailWatcher implements TextWatcher {

    private EditText edit;

    public MailWatcher(EditText et){
        this.edit = et;
    }

    private String correctMail;
    String mail;

    public String getCorrectMail(){
        return this.correctMail;
    }
    public void setCorrectMail(String mail){
        this.correctMail = mail;
    }

    @Override
    public void beforeTextChanged (CharSequence s, int start, int count, int after){
    }
    @Override
    public void onTextChanged (CharSequence s, int start, int before, int count){
        mail = edit.getText().toString();
    }
    @Override
    public void afterTextChanged (Editable s){
        setCorrectMail(mail);
    }
}
