package com.example.vkapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vkapp.tab1;
import com.example.vkapp.Database.UserHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vkapp.databinding.ActivityDashboardBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DashboardActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityDashboardBinding binding;
    private FirebaseUser user;
    private FirebaseAuth mAuth;
    private DatabaseReference refrence;
    String list_dept[] = {"_Admin", "_ESCO", "_#Expense", "_HO", "_Marketing"};

    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent dashboard = getIntent();


        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarDashboard.toolbar);
        /*binding.appBarDashboard.chatpersonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Opening Work", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //Toast.makeText(DashboardActivity.this, "Opening Work", Toast.LENGTH_SHORT).show();
                Intent chatprn = new Intent(DashboardActivity.this,ChatPrnActivity.class);
                startActivity(chatprn);
            }
        });*/
        FloatingActionButton fab = findViewById(R.id.chatperson_btn);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Opening Work", Toast.LENGTH_SHORT).show();
                Intent inti = new Intent(DashboardActivity.this, tab1.class);
                startActivity(inti);
            }
        });

        ListView lv_department = findViewById(R.id.listView_dept);
        Button b = findViewById(R.id.d_my_team);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vivin_custom_arrayadaptor_dept v2 = new vivin_custom_arrayadaptor_dept(DashboardActivity.this, R.layout.fragment_department, list_dept);
                lv_department.setAdapter(v2);
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(

                R.id.department_view, R.id.employee_view, R.id.task_approval,R.id.requistion_approval, R.id.notification_navbar, R.id.calender_navbar,R.id.profile_nav,R.id.logout_navbar )
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_dashboard);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //user = FirebaseAuth.getInstance().getCurrentUser();
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        refrence = FirebaseDatabase.getInstance().getReference("users");
        userID = user.getUid();


        refrence.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserHelper userProfile = snapshot.getValue(UserHelper.class);

                if (userProfile != null){
                    NavigationView navigationView = binding.navView;
                    View headerView = navigationView.getHeaderView(0);
                    TextView name = headerView.findViewById(R.id.name_person);
                    TextView email = headerView.findViewById(R.id.email_person);
                    String firstName = userProfile.fname;
                    String lastname = userProfile.lname;
                    String name2 = firstName + " " + lastname;
                    String email_username = userProfile.username;
                    name.setText(name2);
                    email.setText(email_username);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DashboardActivity.this, "Something wrong happened", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard2, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_dashboard);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                logout();
                return true;
            case R.id.profile_three:
                Intent forProfile = new Intent(DashboardActivity.this,ProfileActivity.class);
                startActivity(forProfile);
                return true;
            case R.id.exit:
                exit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void logout(){
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this, "Logged Out Succesfully!", Toast.LENGTH_SHORT).show();
        Intent fromdb = new Intent(DashboardActivity.this,LoginActivity.class);
        startActivity(fromdb);
    }

    public void exit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
        builder.setMessage("Are you sure want to exit?");
        builder.setCancelable(true);

        builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });
        builder.setPositiveButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }



}