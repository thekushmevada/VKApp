package com.example.vkapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vkapp.ForgotPasswordActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    private EditText username,password;
    TextView DAccount,FPassword;
    boolean passwordVisible;
    private Button submit,signup;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username_signup);
        password = findViewById(R.id.password_signup);

        mAuth = FirebaseAuth.getInstance();

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

        Intent inti = getIntent();
        Intent signin = getIntent();
        Intent fromlogout = getIntent();
        Intent fromdb = getIntent();
        submit = findViewById(R.id.SubmitButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String f_username = username.getText().toString().trim();
                String f_password = password.getText().toString().trim();

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

                mAuth.signInWithEmailAndPassword(f_username,f_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                            if (user.isEmailVerified()){
                                Intent dashboard = new Intent(LoginActivity.this,DashboardActivity.class);
                                startActivity(dashboard);
                                Toast.makeText(LoginActivity.this, "succesfully logged in!", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                user.sendEmailVerification();
                                Toast.makeText(LoginActivity.this, "Check email for verification!", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        DAccount = findViewById(R.id.DontHaveAcc);
        DAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpPage = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(signUpPage);
                Toast.makeText(LoginActivity.this, "Please enter data to SignUp!", Toast.LENGTH_SHORT).show();
            }
        });

        FPassword = findViewById(R.id.ForgotPassword);
        FPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forFPassword = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(forFPassword);
            }
        });

    }
}
