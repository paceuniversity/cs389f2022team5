package com.example.instagive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        TextView result = findViewById(R.id.result);
      //  result.setText("\nEmail: instagive2022@gmail.com\n \nPhone: 1-800-instagive\n \nMailing Address: One Pace Plaza New York, NY 10083\n \nSocials: @instaglve");
    }
}