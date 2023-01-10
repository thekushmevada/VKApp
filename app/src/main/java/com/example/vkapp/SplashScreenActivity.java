package com.example.vkapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedinstanceState){
        super.onCreate(savedinstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        LoadingDialog loadingDialog = new LoadingDialog(SplashScreenActivity.this);
        Intent inti = getIntent();
        SplashScreenActivity.this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingDialog.startLoading();
                Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(i);
            }
        },2000);

    }
}

