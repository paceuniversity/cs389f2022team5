package com.example.instagive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Destination extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        radioGroup = findViewById(R.id.radioGroup);
        Intent intent = getIntent();
        String pick_Up = intent.getStringExtra("Pick Up");
    }

    public void checkCategoryButton(View v) { //variable for which category is selected
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

       // Toast.makeText(context: this, "Selected category: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}