package com.example.vkapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vkapp.Database.UserHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseUser user;
    private DatabaseReference reference;

    private String userId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent inte = getIntent();



        setContentView(R.layout.content_profile);
        ListView listView_profile = findViewById(R.id.listview_profile);
        LinearLayout ll = findViewById(R.id.ll);
        String listp [] = {"DEPARTMENT","BIRTHDATE","ADDRESS","PHONE NUMBER","jkldsfjksdfjl","flkdsflsdlkf","dlkfldsk","kdsfksldk",";lfksd;lfkl;"};
        String listk [] = new String[8];

        vivin_custom_arrayadaptor_profile vp = new vivin_custom_arrayadaptor_profile(ProfileActivity.this, R.layout.content_profile, listp, listk);
        listView_profile.setAdapter(vp);

        listView_profile.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int lastFirstVisibleItem;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                if(lastFirstVisibleItem<firstVisibleItem){

                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) ll.getLayoutParams();
                    params.height = 150;
                    ll.setLayoutParams(params);
                }
                if(lastFirstVisibleItem>firstVisibleItem){

                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) ll.getLayoutParams();
                    params.height = 530;
                    ll.setLayoutParams(params);
                }
                lastFirstVisibleItem=firstVisibleItem;
            }
        });

        // CODE FOR FIREBASE ***********************

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("users");
        userId = user.getUid();

        final TextView name = findViewById(R.id.name);
        final TextView email = findViewById(R.id.email_profile);

        reference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserHelper userProfile = snapshot.getValue(UserHelper.class);

                if (userProfile != null) {
                    String f_name = userProfile.fname;
                    String f_lname = userProfile.lname;
                    String f_email = userProfile.username;
                    String name2 = f_name + " " + f_lname;
                    String department = userProfile.department;
                    String phoneNo = userProfile.phoneNo;
                    String address = userProfile.address;

                    name.setText(name2);
                    email.setText(f_email);
                    listk[0] = department;
                    listk[2] = address;
                    listk[3] = phoneNo;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ProfileActivity.this, "Some Error Occured", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
