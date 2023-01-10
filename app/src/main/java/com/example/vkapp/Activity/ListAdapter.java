package com.example.vkapp.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.vkapp.R;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<UserActivity> {
    public ListAdapter(Context context, ArrayList<UserActivity> userArrayList){
        super(context, R.layout.listitem_department,userArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        UserActivity user = getItem(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_department, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.profilepic);
        TextView userName = convertView.findViewById(R.id.person_name);
        TextView lastMsg = convertView.findViewById(R.id.lastmsg);
        TextView time = convertView.findViewById(R.id.msgtime);

        imageView.setImageResource(user.imageid);
        userName.setText(user.name);
        lastMsg.setText(user.lastmsg);
        return super.getView(position, convertView, parent);
    }
}
