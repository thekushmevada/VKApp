package com.example.vkapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class tab1 extends AppCompatActivity {

    //String name[] = {"vivin","kush","rahul","manoj","sweta"};


    /*public void pas(){
        ListView listview;
        Button addButton;
        EditText GetValue;
        String[] ListElements = new String[] {
                "Android",
                "PHP",
                "Python",
        };

        //setContentView(R.layout.fragment_department);

        listview = findViewById(R.id.listView1);

        final List<String> ListElementsArrayList = new ArrayList<>(Arrays.asList(ListElements));
        final ArrayAdapter<String> adapter = new ArrayAdapter<>
                (tab1.this, android.R.layout.simple_list_item_1, ListElementsArrayList);
        listview.setAdapter(adapter);

    }*/

    private FirebaseUser user;
    private DatabaseReference reference;

    private String userId;

    String list[] = {"_#66", "_#58", "_#99", "_#23", "_#43"};
    String list2[] = {"vivn", "kush", "dhoni", "rahul", "ajay"};
    String list3[] = {"NO RECORD FOUND"};
    String list4[] = {"NO RECORD FOUND"};
    String list5[] = {"NO RECORD FOUND"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent chatprn = getIntent();
        setContentView(R.layout.tab1_layout);
        ListView listView = findViewById(R.id.listview2);
        TextView pending = findViewById(R.id.pendingt1);
        TextView working = findViewById(R.id.workingt1);
        TextView done = findViewById(R.id.donet1);
        TextView all_task = findViewById(R.id.alltaskt1);
        TextView given_by_me = findViewById(R.id.givenbymet1);
        ImageView i7 = findViewById(R.id.imageView7);

        pending.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                /*Intent inte = new Intent(tab1.this,tab2.class);
                startActivity(inte);*/
                pending.setBackgroundColor(Color.parseColor("#81E457"));
                working.setBackgroundColor(Color.parseColor("#50B6E1"));
                done.setBackgroundColor(Color.parseColor("#50B6E1"));
                all_task.setBackgroundColor(Color.parseColor("#50B6E1"));
                given_by_me.setBackgroundColor(Color.parseColor("#50B6E1"));

                vivin_custom_arrayadaptor2 v2 = new vivin_custom_arrayadaptor2(tab1.this, R.layout.tab1_layout, list2);
                listView.setAdapter(v2);
            }
        });


        working.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                /*Intent inte = new Intent(tab1.this,tab1.class);
                startActivity(inte);*/
                vivin_custom_arrayadaptor v1 = new vivin_custom_arrayadaptor(tab1.this, R.layout.tab1_layout, list);
                listView.setAdapter(v1);

                pending.setBackgroundColor(Color.parseColor("#50B6E1"));
                working.setBackgroundColor(Color.parseColor("#81E457"));
                done.setBackgroundColor(Color.parseColor("#50B6E1"));
                all_task.setBackgroundColor(Color.parseColor("#50B6E1"));
                given_by_me.setBackgroundColor(Color.parseColor("#50B6E1"));
            }
        });


        done.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                /*Intent inte = new Intent(tab1.this,tab3.class);
                startActivity(inte);*/
                vivin_custom_arrayadaptor3 v3 = new vivin_custom_arrayadaptor3(tab1.this, R.layout.tab1_layout, list3);
                listView.setAdapter(v3);

                pending.setBackgroundColor(Color.parseColor("#50B6E1"));
                working.setBackgroundColor(Color.parseColor("#50B6E1"));
                done.setBackgroundColor(Color.parseColor("#81E457"));
                all_task.setBackgroundColor(Color.parseColor("#50B6E1"));
                given_by_me.setBackgroundColor(Color.parseColor("#50B6E1"));
            }
        });


        all_task.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                /*Intent inte = new Intent(tab1.this,tab4.class);
                startActivity(inte);*/
                vivin_custom_arrayadaptor4 v4 = new vivin_custom_arrayadaptor4(tab1.this, R.layout.tab1_layout, list4);
                listView.setAdapter(v4);

                pending.setBackgroundColor(Color.parseColor("#50B6E1"));
                working.setBackgroundColor(Color.parseColor("#50B6E1"));
                done.setBackgroundColor(Color.parseColor("#50B6E1"));
                all_task.setBackgroundColor(Color.parseColor("#81E457"));
                given_by_me.setBackgroundColor(Color.parseColor("#50B6E1"));
            }
        });


        given_by_me.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                /*Intent inte = new Intent(tab1.this,tab5.class);
                startActivity(inte);*/
                vivin_custom_arrayadaptor5 v5 = new vivin_custom_arrayadaptor5(tab1.this, R.layout.tab1_layout, list5);
                listView.setAdapter(v5);

                pending.setBackgroundColor(Color.parseColor("#50B6E1"));
                working.setBackgroundColor(Color.parseColor("#50B6E1"));
                done.setBackgroundColor(Color.parseColor("#50B6E1"));
                all_task.setBackgroundColor(Color.parseColor("#50B6E1"));
                given_by_me.setBackgroundColor(Color.parseColor("#81E457"));
            }
        });

        /*Intent tab1 = getIntent();*/


        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(tab1.this, DashboardActivity.class);
                startActivity(inte);
            }
        });


        vivin_custom_arrayadaptor v = new vivin_custom_arrayadaptor(tab1.this, R.layout.tab1_layout, list);
        listView.setAdapter(v);


    }
}
