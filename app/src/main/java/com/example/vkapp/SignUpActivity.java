package com.example.vkapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vkapp.Database.UserHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    Button signup2;
    EditText firstname,lastname,username,password,confirmpassword,e_address,phoneNumber;
    boolean passwordVisible;
    private FirebaseAuth mAuth;
    Spinner spinner;
    public String[] department = {"Select Department","Admin", "HR", "Finance", "Marketing", "IT"};
    public String f_dept;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);
        Intent signUpPage = getIntent();


        mAuth = FirebaseAuth.getInstance();

        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        username=findViewById(R.id.username_signup);
        password=findViewById(R.id.password_signup);
        confirmpassword=findViewById(R.id.confirmpassword_signup);
        spinner=findViewById(R.id.spinner);
        e_address=findViewById(R.id.address);
        phoneNumber=findViewById(R.id.phoneNo);

        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if (motionEvent.getRawX()>=password.getRight()-password.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = password.getSelectionEnd();
                        if (passwordVisible){
                            //set drawable image
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            //for hide password
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }
                        else {
                            //set drawable image
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            //for hide password
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        password.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        confirmpassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right2 = 2;
                if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if (motionEvent.getRawX()>=confirmpassword.getRight()-confirmpassword.getCompoundDrawables()[Right2].getBounds().width()){
                        int selection2 = confirmpassword.getSelectionEnd();
                        if (passwordVisible){
                            //set drawable image
                            confirmpassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            //for hide password
                            confirmpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        else {
                            //set drawable image
                            confirmpassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            //for hide password
                            confirmpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }
                        confirmpassword.setSelection(selection2);
                        return true;
                    }
                }
                return false;
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SignUpActivity.this, android.R.layout.simple_spinner_item, department);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //String f_dept = "Add";
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                    String value = adapterView.getItemAtPosition(position).toString();
                    f_dept = value;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //void
            }
        });

        signup2 = findViewById(R.id.SignUp2);
        signup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String f_fname = firstname.getText().toString().trim();
                String f_lname = lastname.getText().toString().trim();
                String f_username = username.getText().toString().trim();
                String f_password = password.getText().toString().trim();
                String f_confirmpassword = confirmpassword.getText().toString().trim();
                String f_address = e_address.getText().toString().trim();
                String f_phoneNo = phoneNumber.getText().toString().trim();

                if (f_fname.isEmpty()) {
                    firstname.setError("First Name is Required");
                    firstname.requestFocus();
                    return;
                }
                if (f_lname.isEmpty()) {
                    lastname.setError("Last Name is Required");
                    lastname.requestFocus();
                    return;
                }
                if (f_username.isEmpty()) {
                    username.setError("Email is Required");
                    username.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(f_username).matches()){
                    username.setError("Please enter valid email");
                    username.requestFocus();
                    return;
                }
                if (f_password.isEmpty()) {
                    password.setError("Please Enter Password");
                    password.requestFocus();
                    return;
                }
                if (f_password.length() < 6) {
                    password.setError("Password must me 6 characters long");
                    password.requestFocus();
                    return;
                }
                if (!f_password.equals(f_confirmpassword)){
                    confirmpassword.setError("Please Enter the password correctly");
                    confirmpassword.requestFocus();
                    return;
                }
                if (f_address.isEmpty()) {
                    e_address.setError("Address is Required");
                    e_address.requestFocus();
                    return;
                }
                if (f_phoneNo.isEmpty()) {
                    phoneNumber.setError("Phone Number is Required");
                    phoneNumber.requestFocus();
                    return;
                }
                /*if (f_dept.isEmpty()) {
                    spinner.requestFocus();
                    return;
                }*/

                mAuth.createUserWithEmailAndPassword(f_username,f_password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){

                                    UserHelper user = new UserHelper(f_fname,f_lname,f_username,f_password,f_dept,f_address,f_phoneNo);
                                    FirebaseDatabase.getInstance().getReference("users")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()){
                                                        Toast.makeText(SignUpActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
                                                        Intent signin = new Intent(SignUpActivity.this, LoginActivity.class);
                                                        startActivity(signin);
                                                    }
                                                    else {
                                                        Toast.makeText(SignUpActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });
                                }else {
                                    Toast.makeText(SignUpActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                /*Map<String,Object> user = new HashMap<>();
                user.put("FirtName", f_fname);
                user.put("LastName",f_lname);
                user.put("UserName",f_username);
                user.put("Password",f_password);

                db.collection("user")
                                .add(user)
                                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                            @Override
                                            public void onSuccess(DocumentReference documentReference) {
                                                Toast.makeText(SignUpActivity.this, "Successfully Enrolled", Toast.LENGTH_SHORT).show();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(SignUpActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                            }
                        });*/


            }
        });
    }
}
