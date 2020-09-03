package com.example.rapha.kita_app;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ActivityOne extends AppCompatActivity {

    private Handler myHandler = new Handler();

    private int progressStatus = 0;
    private ProgressBar myBar;
    private TextView easyKita;
    private Button login;
    private TextView loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "KristenITC.TTF");
        myBar = (ProgressBar) findViewById(R.id.progressBar1);
        easyKita = (TextView) findViewById(R.id.textView1);
        login = (Button) findViewById(R.id.button1);
        loading = (TextView) findViewById(R.id.textView2);
        easyKita.setTypeface(myTypeface);
        myBar.getProgressDrawable().setColorFilter(Color.MAGENTA, PorterDuff.Mode.SRC_IN);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < 100){
                    progressStatus++;
                    myBar.setProgress(progressStatus);
                    android.os.SystemClock.sleep(17);
                }
                myHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loading.setText("Loading completed!");
                        login.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();

        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(new Intent(ActivityOne.this, Login.class));
            }
        });
    }
}
