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
import com.google.firebase.database.ValueEventListener;

public class EditProfile extends AppCompatActivity {
    EditText editName, editEmail, editPassword, editPhone;
    TextView userNameText;
    Button saveButton, logOut;
    String nameUser, emailUser, usernameUser, passwordUser, phoneUser;
    DatabaseReference reference;
    DatabaseReference userRef;
    private boolean userCheck = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        reference = FirebaseDatabase.getInstance().getReference("users");
        userRef = FirebaseDatabase.getInstance().getReference("users");
        Intent intent = getIntent();
        nameUser = intent.getStringExtra("name");
        emailUser = intent.getStringExtra("email");
        phoneUser = intent.getStringExtra("phone");
        usernameUser = intent.getStringExtra("username");
        passwordUser = intent.getStringExtra("password");
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPhone = findViewById(R.id.editPhone);
        userNameText = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        saveButton = findViewById(R.id.saveButton);
        logOut = findViewById(R.id.logOut);
        showData();

        userNameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditProfile.this, "Username is permanent!", Toast.LENGTH_SHORT).show();
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  login = new Intent(EditProfile.this, Login.class);
                startActivity(login);
                Toast.makeText(EditProfile.this, "Log Out Successful", Toast.LENGTH_SHORT).show();
            }
        });





        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNameChanged() || isPasswordChanged() || isPhoneChanged() || isEmailChanged()){
                    Toast.makeText(EditProfile.this, "Saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditProfile.this, "No Changes Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean isNameChanged() {
        if (!nameUser.equals(editName.getText().toString())){
            reference.child(usernameUser).child("name").setValue(editName.getText().toString());
            nameUser = editName.getText().toString();
            return true;
        } else {
            return false;
        }
    }
   /* private boolean isUserChanged() {
        if (!usernameUser.equals(editUsername.getText().toString())){
            userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.hasChild(editUsername.getText().toString())) {
                        Toast.makeText(EditProfile.this, "This username is already taken.", Toast.LENGTH_SHORT).show();
                        userCheck = false;
                    }
                    else {
                        userRef.child(usernameUser).child("userName").setValue(editUsername.getText().toString());
                        nameUser = editUsername.getText().toString();
                        userCheck = true;
                    }
                } //end of onDataChange

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            return userCheck;
         //   reference.child(usernameUser).child("userName").setValue(editName.getText().toString());
          //  nameUser = editName.getText().toString();

        } //end of if

        else { //start of else
            return false;
        } //end of else
    } */


    private boolean isPhoneChanged() {
        if (!phoneUser.equals(editPhone.getText().toString())){
            reference.child(usernameUser).child("phone").setValue(editPhone.getText().toString());
            phoneUser = editName.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmailChanged() {
        if (!emailUser.equals(editEmail.getText().toString())){
            reference.child(usernameUser).child("email").setValue(editEmail.getText().toString());
            emailUser = editEmail.getText().toString();
            return true;
        } else {
            return false;
        }
    }
    private boolean isPasswordChanged() {
        if (!passwordUser.equals(editPassword.getText().toString())){
            reference.child(usernameUser).child("password").setValue(editPassword.getText().toString());
            passwordUser = editPassword.getText().toString();
            return true;
        } else {
            return false;
        }
    }
    public void showData(){

        editName.setText(nameUser);
        editEmail.setText(emailUser);
        userNameText.setText("Username: " +usernameUser);
        editPhone.setText(phoneUser);
        editPassword.setText(passwordUser);
    }
}