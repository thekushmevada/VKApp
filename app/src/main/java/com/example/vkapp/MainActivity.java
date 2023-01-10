package com.example.vkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.vkapp.Activity.ListAdapter;
import com.example.vkapp.Database.DBHandler;
import com.example.vkapp.Database.Employee;
import com.example.vkapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Intent in = new Intent(this,SplashScreenActivity.class);
        startActivity(in);

    }


}