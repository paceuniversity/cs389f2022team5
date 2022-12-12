package com.example.instagive;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/*import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
*/
public class Register extends AppCompatActivity {
    private EditText usernameText;
    private EditText nameText;
    private EditText phoneText;
    private EditText emailText;
    private EditText passwordText;
    private EditText confirmText;
    private Button registerButton;
    private TextView loginNow;
   // FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference reference;
    // Write a message to the database

   // private DatabaseReference fire = FirebaseDatabase.getInstance().getReferenceFromUrl("https://instagive-369922-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


       // mAuth = FirebaseAuth.getInstance();
       // DatabaseReference fire = FirebaseDatabase.getInstance().getReferenceFromUrl("https://instagive-369922-default-rtdb.firebaseio.com/");

        usernameText = findViewById(R.id.userName);
        nameText = findViewById(R.id.name);
        phoneText = findViewById(R.id.userPhone);
        emailText = findViewById(R.id.userEmail);
        passwordText = findViewById(R.id.password);
        confirmText = findViewById(R.id.confirmPassword);
        registerButton = findViewById(R.id.register_button);
        loginNow = findViewById(R.id.login);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String fullName = nameText.getText().toString();
               String phone = phoneText.getText().toString();
               String email = emailText.getText().toString();
               String username = usernameText.getText().toString();
               String password = passwordText.getText().toString();
               String confirmPass = confirmText.getText().toString();

                if(fullName.isEmpty() || phone.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPass.isEmpty())
                {
                    Toast.makeText(Register.this,"Please fill all fields", Toast.LENGTH_SHORT).show();
                }

                else if(!password.equals(confirmPass))
                {
                    Toast.makeText(Register.this,"Passwords do not match", Toast.LENGTH_SHORT).show();
                }
                else{
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                userClass newUser = new userClass(fullName,email,phone,username,password);
                reference.child(username).setValue(newUser);

                Toast.makeText(Register.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent); }
             /*  if(fullName.isEmpty() || phone.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPass.isEmpty())
               {
                   Toast.makeText(Register.this,"Please fill all fields", Toast.LENGTH_SHORT).show();
               }

                else if(!password.equals(confirmPass))
               {
                   Toast.makeText(Register.this,"Passwords do not match", Toast.LENGTH_SHORT).show();
               }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(Register.this, "Authentication Success.",
                                            Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                 /*else{ //firebase implementation below

                  /*  fire.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.hasChild(username)){
                                    Toast.makeText(Register.this,"This username is already taken.", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    fire.child("users").child(username).child("fullname").setValue(fullName);
                                    fire.child("users").child(username).child("phone").setValue(phone);
                                    fire.child("users").child(username).child("email").setValue(email);
                                    fire.child("users").child(username).child("password").setValue(password);

                                    Toast.makeText(Register.this,"Registration Complete", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                        } //end of onDataChange

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                   fire.child("users").child(username).child("fullname").setValue(fullName);
                   fire.child("users").child(username).child("phone").setValue(phone);
                   fire.child("users").child(username).child("email").setValue(email);
                   fire.child("users").child(username).child("password").setValue(password);

                   Toast.makeText(Register.this,"Registration Complete", Toast.LENGTH_SHORT).show();
                   finish();
               } */ //end of else

            } //end of onClick
        }); //end of setOnClickListener for register button

        loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



}

}