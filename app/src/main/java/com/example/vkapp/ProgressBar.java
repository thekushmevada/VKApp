package com.example.vkapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProgressBar extends AppCompatActivity {
    private Activity activity;
    private AlertDialog dialog;

    ProgressBar(Activity myactivity){
        activity = myactivity;
    }



    void startLoading(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.activity_splash_screen,null));
        builder.setCancelable(false);

        dialog=builder.create();
        dialog.show();
    }

    void dismissDialog(){
        dialog.dismiss();
    }
}
