package com.example.instagive;


import androidx.annotation.NonNull;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.instagive.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instagive.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    TextView profileName, profileEmail, profileUsername, profilePassword;
    TextView titleName, titleUsername;
    private int donoCheck;

    Button editProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController); */
        setContentView(R.layout.activity_main);
        profileUsername = findViewById(R.id.inputName);

        // setContentView(R.layout.activity_main);
       /* profileName = findViewById(R.id.profileName);
        profileEmail = findViewById(R.id.profileEmail);
        profileUsername = findViewById(R.id.name);
        profilePassword = findViewById(R.id.profilePassword);
        titleName = findViewById(R.id.titleName);
        titleUsername = findViewById(R.id.titleUsername);
        editProfile = findViewById(R.id.editButton); */
        readAllUserData();
        donoCheck = getDonoCheck();

        /*editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passUserData();
            }
        }); */
    }


    public void launchMissionStatement (View view){

        Intent intent = new Intent(this,MissionStatement.class);
        EditText nameEditText = (EditText) findViewById(R.id.inputName);
        String name = nameEditText.getText().toString();
        intent.putExtra("Name", name);
        startActivity(intent);
    }
    public void launchDonationForm(View view) {
      //  Log.d(LOG_TAG, "Donate button clicked!"); //Just for the Log

       // Intent intent = new Intent(this,DonationForm.class);
        //EditText nameEditText = (EditText) findViewById(R.id.inputName);
        //String name = nameEditText.getText().toString();
        //if(name.isEmpty()) {
           // Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
        //}
        //else{
            String userUsername = profileUsername.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("userName").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                    String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                    String phoneFromDB = snapshot.child(userUsername).child("phone").getValue(String.class);
                    String usernameFromDB = snapshot.child(userUsername).child("userName").getValue(String.class);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
                    int donationsFromDB = snapshot.child(userUsername).child("donations").getValue(Integer.class);
                    donoCheck = donationsFromDB;
                    Intent intent = new Intent(MainActivity.this, DonationForm.class);
                    Bundle form = new Bundle();
                    form.putString("name", nameFromDB);
                    form.putString("email", emailFromDB);
                    form.putString("phone", phoneFromDB);
                    form.putString("username", usernameFromDB);
                    form.putString("password", passwordFromDB);
                    form.putInt("donations", donationsFromDB);
                    intent.putExtras(form);
                    startActivity(intent);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
       // }
    }



    public void readAllUserData(){
        Intent intent = getIntent();
        String nameUser = intent.getStringExtra("name");
        String emailUser = intent.getStringExtra("email");
        String phoneUser = intent.getStringExtra("phone");
        String usernameUser = intent.getStringExtra("username");
        String passwordUser = intent.getStringExtra("password");
        profileUsername.setText(usernameUser);
        /* titleName.setText(nameUser);
        titleUsername.setText(usernameUser);
        profileName.setText(nameUser);
        profileEmail.setText(emailUser);
        profileUsername.setText(usernameUser);
        profilePassword.setText(passwordUser); */
    }
    public void editUserData(){

       /* EditText nameEditText = (EditText) findViewById(R.id.inputName);
        String name = nameEditText.getText().toString();
        if(name.isEmpty()) {
         Toast.makeText(MainActivity.this, "Please enter your username", Toast.LENGTH_SHORT).show();
        }
        else if(!name.equals("")){

        }
        else { */
            String userUsername = profileUsername.getText().toString().trim();
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
            Query checkUserDatabase = reference.orderByChild("userName").equalTo(userUsername);
            checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                        String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                        String phoneFromDB = snapshot.child(userUsername).child("phone").getValue(String.class);
                        String usernameFromDB = snapshot.child(userUsername).child("userName").getValue(String.class);
                        String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
                        int donationsFromDB = snapshot.child(userUsername).child("donations").getValue(Integer.class);

                        Intent intent = new Intent(MainActivity.this, EditProfile.class);
                        Bundle form = new Bundle();
                        form.putString("name", nameFromDB);
                        form.putString("email", emailFromDB);
                        form.putString("phone", phoneFromDB);
                        form.putString("username", usernameFromDB);
                        form.putString("password", passwordFromDB);
                        form.putInt("donations", donationsFromDB);
                        intent.putExtras(form);
                        startActivity(intent);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            }); //end of else

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //creates the 3 dot menu on Main
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

        //return super.onCreateOptionsMenu(menu);
    }


    private int getDonoCheck()
    {
        String userUsername = profileUsername.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("userName").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    int donationsFromDB = snapshot.child(userUsername).child("donations").getValue(Integer.class);
                    donoCheck = donationsFromDB;

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        return donoCheck;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = getIntent();
       // Bundle mBundle = new Bundle();
       // mBundle = getIntent().getExtras();
       // intent.putExtras(mBundle);
       // donoCheck = getDonoCheck();

        switch (item.getItemId()) {
            case R.id.contact:
                 intent = new Intent(MainActivity.this, Contact.class);
                //intent.putExtra(EXTRA_MESSAGE, mMessage);
                startActivity(intent);
                return true;

            case R.id.editProfile:
                String editActivity = "EditProfile";
                editUserData();
             // intent = new Intent(MainActivity.this, EditProfile.class);
               // startActivity(intent);
                return true;
            case R.id.history:
                donoCheck = getDonoCheck();
                if(donoCheck>0)
                {
                    Intent history = new Intent(MainActivity.this, History.class);
                    //intent.putExtra(EXTRA_MESSAGE, mMessage);
                    String username = profileUsername.getText().toString().trim();
                    history.putExtra("username", username);
                    startActivity(history);
                    return true;
                }
                   else {

                    Toast.makeText(MainActivity.this, "Click 'DONATE' to submit your first request!", Toast.LENGTH_LONG).show();
                    return false;
                }
        }
        return super.onOptionsItemSelected(item);

    }
}




















/*
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.instagive.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final String LOG_TAG = DonationForm.class.getSimpleName();
    private String nameUser, emailUser, userNameUser, userPhone, passwordUser;
    private Bundle form = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        getAllUserData();

        EditText nameEditText = (EditText) findViewById(R.id.inputName);
        String name = nameEditText.getText().toString();
    }

    public void getAllUserData(){
        Intent intent = getIntent();
         nameUser = intent.getStringExtra("name");
         emailUser = intent.getStringExtra("email");
         userNameUser = intent.getStringExtra("username");
         userPhone = intent.getStringExtra("phone");
         passwordUser = intent.getStringExtra("password");
       /* titleName.setText(nameUser);
        titleUsername.setText(usernameUser);
        profileName.setText(nameUser);
        profileEmail.setText(emailUser);
        profileUsername.setText(usernameUser);
        profilePassword.setText(passwordUser); */
/*
import androidx.annotation.NonNull;}

    public Bundle passUserData(){
        String userUsername = userNameUser.toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("userName").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                    String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                    String phoneFromDB = snapshot.child(userUsername).child("phone").getValue(String.class);
                    String usernameFromDB = snapshot.child(userUsername).child("userName").getValue(String.class);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);

                    //Intent intent = new Intent(MainActivity.this, EditProfile.class);
                    form.putString("name", nameFromDB);
                    form.putString("email", emailFromDB);
                    form.putString("phone", phoneFromDB);
                    form.putString("username", usernameFromDB);
                    form.putString("password", passwordFromDB);

                   //intent.putExtras(form);
                    //startActivity(intent);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
            return form;
    }

    public void launchMissionStatement (View view){

        Intent intent = new Intent(this,MissionStatement.class);
        EditText nameEditText = (EditText) findViewById(R.id.inputName);
        String name = nameEditText.getText().toString();
        intent.putExtra("Name", name);
        startActivity(intent);
    }
    public void launchDonationForm(View view) {
        Log.d(LOG_TAG, "Donate button clicked!"); //Just for the Log

        Intent intent = new Intent(this,DonationForm.class);
        EditText nameEditText = (EditText) findViewById(R.id.inputName);
        String name = nameEditText.getText().toString();
        if(name.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
        }
        else{
        intent.putExtra("Name", name);
        startActivity(intent); }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //creates the 3 dot menu on Main
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       /* Intent intent = getIntent();
        Bundle mBundle = new Bundle();
        mBundle = getIntent().getExtras();
        intent.putExtras(mBundle); */
/*
        switch (item.getItemId()) {
            case R.id.contact:
               Intent intent = new Intent(MainActivity.this, Contact.class);
                //intent.putExtra(EXTRA_MESSAGE, mMessage);
                startActivity(intent);
                return true;

            case R.id.editProfile:

                  intent = new Intent(MainActivity.this, EditProfile.class);

                Bundle edit = new Bundle(passUserData());

                intent.putExtras(edit);
                startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
*/