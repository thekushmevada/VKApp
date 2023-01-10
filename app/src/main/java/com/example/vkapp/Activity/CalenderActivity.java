package com.example.vkapp.Activity;

import android.os.Bundle;
import android.view.Window;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vkapp.R;
import com.example.vkapp.ui.Calender.Calender;
import com.example.vkapp.ui.Calender.CalenderViewModel;

public class CalenderActivity extends AppCompatActivity {
    protected TextView setdate;
    protected CalendarView calender;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(androidx.navigation.ui.R.color.design_default_color_primary));
        setContentView(R.layout.fragment_calender);

        setdate = findViewById(R.id.set_date);
        calender = findViewById(R.id.calendarView);

        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                String Date =dayOfMonth + " " + (month+1) + " " +year;
                setdate.setText(Date);
            }
        });
    }
}
