package com.example.vkapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

public class vivin_custom_arrayadaptor_profile extends ArrayAdapter<String> {
    int clickcount=0;
    String[] list;
    String[] listp;
    Context context;// we create this for giving context for toast

    public vivin_custom_arrayadaptor_profile(@NonNull Context context, int resource, String[] list, String[] listp) {
        super(context, resource, list);
        this.list = list;
        this.listp = listp;
        this.context = context;
    }

    // here we have to override two method(getItem,getView)
    @Nullable
    @Override
    public String getItem(int position) {
        return list[position];
    }

    @Nullable
    public String getItem2(int position) {
        return listp[position];
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.profile_sup, parent, false);
        TextView t = convertView.findViewById(R.id.head);
        t.setText(getItem(position));

        TextView t2 = convertView.findViewById(R.id.details);
        t2.setText(getItem2(position));

        return convertView;
    }
}


