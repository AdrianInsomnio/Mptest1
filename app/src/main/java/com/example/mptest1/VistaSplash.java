package com.example.mptest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mptest1.Vista.LoginView.LoginView.VistaLogin;

public class VistaSplash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash= new Intent(VistaSplash.this, VistaLogin.class);
                startActivity(splash);
                finish();

            }
        },SPLASH_TIME_OUT);
    }
}
