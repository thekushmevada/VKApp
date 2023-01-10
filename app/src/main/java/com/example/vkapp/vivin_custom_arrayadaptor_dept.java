package com.example.vkapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class vivin_custom_arrayadaptor_dept extends ArrayAdapter<String> {

    String[] list;
    Context context;// we create this for giving context for toast

    public vivin_custom_arrayadaptor_dept(@NonNull Context context, int resource, @NonNull String[] list) {
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
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.department, parent, false);
        TextView t = convertView.findViewById(R.id.dept);
        t.setText(getItem(position));

        return convertView;
    }
}


