package com.example.instagive;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.instagive.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final String LOG_TAG = DonationForm.class.getSimpleName();
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        EditText nameEditText = (EditText) findViewById(R.id.inputName);
        String name = nameEditText.getText().toString();
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
        intent.putExtra("Name", name);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //creates the 3 dot menu on Main
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mission:
                Intent intent = new Intent(MainActivity.this, Contact.class);
                //intent.putExtra(EXTRA_MESSAGE, mMessage);
                startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}