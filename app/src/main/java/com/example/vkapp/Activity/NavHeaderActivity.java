package com.example.vkapp.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vkapp.DashboardActivity;
import com.example.vkapp.Database.UserHelper;
import com.example.vkapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NavHeaderActivity extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference refrence;

    private String userID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_dashboard);

        user = FirebaseAuth.getInstance().getCurrentUser();
        refrence = FirebaseDatabase.getInstance().getReference("users");
        userID = user.getUid();
        TextView name = findViewById(R.id.name_person);

        refrence.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserHelper userProfile = snapshot.getValue(UserHelper.class);

                //String firstName = userProfile.getFname();

                String firstName = userProfile.fname.toString();
                name.setText(firstName);

                /*if (userProfile != null){
                    firstName =
                }*/

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(NavHeaderActivity.this, "Something wrong happened", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
