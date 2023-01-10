package com.example.vkapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class vivin_custom_arrayadaptor3 extends ArrayAdapter<String> {
    String[] list;
    Context context;// we create this for giving context for toast

    public vivin_custom_arrayadaptor3(@NonNull Context context, int resource, @NonNull String[] list) {
        super(context, resource, list);
        this.list = list;
        this.context = context;
    }

    // here we have to override two method(getItem,getView)
    @Nullable
    @Override
    public String getItem(int position) {
        return list[position];
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.tab3_layout, parent, false);
        TextView t = convertView.findViewById(R.id.textView2);
        t.setText(getItem(position));

        /*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm:ss E");
        LocalDateTime ldt = LocalDateTime.now();
        String sdtf = ldt.format(dtf);
        TextView te = convertView.findViewById(R.id.time);
        te.setText(sdtf);*/

        // on click listener in custom adapter
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you click on: " + list[position] + "\n serial number: " + (position + 1), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}

