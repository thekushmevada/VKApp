package com.example.vkapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;

public class LoadingDialog extends AppCompatActivity {
    private Activity activity;
    private AlertDialog dialog;

    LoadingDialog(Activity myactivity){
        activity = myactivity;
    }

    void startLoading(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        //builder.setView(inflater.inflate(R.layout.activity_splash_screen,null));
        builder.setCancelable(false);

        dialog=builder.create();
        dialog.show();
    }

    void dismissDialog(){
        dialog.dismiss();
    }
}
