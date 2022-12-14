package com.example.instagive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    private EditText usernameText;
    private EditText passwordText;
    private Button loginButton;
    private TextView registerNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        usernameText = findViewById(R.id.userName);
        passwordText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        registerNow = findViewById(R.id.register);

        // Set click listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get username and password from edit texts
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Login.this, "Please fill both fields", Toast.LENGTH_SHORT).show();
                }
                // Validate the login credentials

                else {
                    checkUser();
                    // If the login credentials are correct, start the main activity
                    //Intent intent = new Intent(Login.this, MainActivity.class);
                    //startActivity(intent);
                }
                //set else if username or password is not valid

            }
        });

        registerNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));

            }


        });
    }
        public void checkUser(){
            String userUsername = usernameText.getText().toString().trim();
            String userPassword = passwordText.getText().toString().trim();
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
            Query checkUserDatabase = reference.orderByChild("userName").equalTo(userUsername);
            checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        usernameText.setError(null);
                        String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
                        if (passwordFromDB.equals(userPassword)) {
                            passwordText.setError(null);
                            String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                            String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                            String usernameFromDB = snapshot.child(userUsername).child("userName").getValue(String.class);
                            String phoneFromDB = snapshot.child(userUsername).child("phone").getValue(String.class);
                            int donationsFromDB = snapshot.child(userUsername).child("donations").getValue(Integer.class);
                            Bundle form = new Bundle();
                            form.putString("name", nameFromDB);
                            form.putString("phone", phoneFromDB);
                            form.putString("email", emailFromDB);
                            form.putString("username", usernameFromDB);
                            form.putString("password", passwordFromDB);
                            form.putInt("donations",donationsFromDB);
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            intent.putExtras(form);
                            startActivity(intent);
                        } else {
                            passwordText.setError("Invalid Credentials");
                            passwordText.requestFocus();
                            Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        usernameText.setError("User does not exist");
                        usernameText.requestFocus();
                        Toast.makeText(Login.this, "User does not exist", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }






    }



  /*  private boolean validateLogin(String username, String password) {
        // TODO: Implement login validation

        String userUsername = username;
        String userPassword = password;
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    //username.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userPassword)) {
                        //username.setError(null);
                        String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                        String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                        String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
                        /*Intent intent = new Intent(Login.this, MainActivity.class);
                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("password", passwordFromDB);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login.this,"Incorrect Password", Toast.LENGTH_SHORT).show();
                       // password.setError("Invalid Credentials");
                      //  password.requestFocus();
                    }
                } else {
                    Toast.makeText(Login.this,"Username does not exist", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }


    });
   return true;
}*/

