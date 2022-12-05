package com.example.instagive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Learn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        Intent intent = getIntent();
        String organization = intent.getStringExtra("Organization");
        TextView title = findViewById(R.id.textEditTitle);
        title.setText(organization);

        TextView result = findViewById(R.id.result);
        result.setText("This page will display information about the chosen organization of the user, in this case that was: " + organization);
        Button submitFormButton = findViewById(R.id.returnHome);

        submitFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Learn.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}