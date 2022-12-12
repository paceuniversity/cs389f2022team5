package com.example.instagive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
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
        String name = intent.getStringExtra("name");
        String address = intent.getStringExtra("Address");

        Spinner spinnerOrganizations =findViewById(R.id.spinner_organizations);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.organizations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerOrganizations.setAdapter(adapter);

        RadioButton pickup = (RadioButton)findViewById(R.id.radioButtonPickUp);
        pickup.setText(address);



        Button submitDestinationButton = findViewById(R.id.buttonSubmitForm);


         submitDestinationButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                String pickUP = radioButton.getText().toString();
                String organization = spinnerOrganizations.getSelectedItem().toString();
                Intent intent = new Intent(Destination.this,DonationSummary.class);
                Bundle form = new Bundle();
                form = getIntent().getExtras();
                form.putString("Pick Up", pickUP);
                form.putString("Organization" , organization);
                intent.putExtras(form);
                startActivity(intent);
            }
        });


    }

    public void checkCategoryButton(View v) { //variable for which category is selected
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);



       // Toast.makeText(context: this, "Selected category: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}