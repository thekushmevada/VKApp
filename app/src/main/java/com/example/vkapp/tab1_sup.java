package com.example.vkapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class tab1_sup extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1_sup);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm:ss E");
        LocalDateTime ldt = LocalDateTime.now();
        String sdtf = ldt.format(dtf);
        TextView t = findViewById(R.id.time);
        t.setText(sdtf);

        /* Intent inte = new Intent(tab1.this,MainActivity.class);
        startActivity(inte);*/
    }
}
