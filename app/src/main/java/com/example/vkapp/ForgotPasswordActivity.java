package com.example.vkapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vkapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText email;
    private Button resetButton;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        Intent forFPassword = getIntent();

        email = findViewById(R.id.email_signup);
        resetButton = findViewById(R.id.resetPassword);

        mAuth = FirebaseAuth.getInstance();

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String femail = email.getText().toString().trim();

                if (femail.isEmpty()) {
                    email.setError("Email is Required");
                    email.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(femail).matches()){
                    email.setError("Please enter valid email");
                    email.requestFocus();
                    return;
                }

                mAuth.sendPasswordResetEmail(femail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(ForgotPasswordActivity.this, "Check your email", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ForgotPasswordActivity.this, "Try again, Something went Wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
