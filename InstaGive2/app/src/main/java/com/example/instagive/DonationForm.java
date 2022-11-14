package com.example.instagive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class DonationForm extends AppCompatActivity {

    private static final String LOG_TAG = DonationForm.class.getSimpleName();

    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_form);

        radioGroup = findViewById(R.id.radioGroup);
        TextView textViewTitle = findViewById(R.id.textFormTitle);
        TextView textViewDescription = findViewById(R.id.textFormDescription);
        TextView textViewCategory = findViewById(R.id.textFormCategory);

        EditText itemNameEditText = (EditText) findViewById(R.id.inputNameOfItem);
        String itemName = itemNameEditText.getText().toString(); //This it variable with users input - item name


        EditText quantityEditText = (EditText) findViewById(R.id.inputQuantity);
        String quantity = quantityEditText.getText().toString();


        EditText addressEditText = (EditText) findViewById(R.id.inputFormPickupAddress);
        String pickupAddress = addressEditText.getText().toString();


        EditText phoneNumEditText = (EditText) findViewById(R.id.inputFormPhoneNum);
        String phoneNum = phoneNumEditText.getText().toString();


        EditText dateEditText = (EditText) findViewById(R.id.inputFormDate);


        EditText noteEditText = (EditText) findViewById(R.id.inputMultiLineNotes);


        Button submitFormButton = findViewById(R.id.buttonSubmitForm);

        submitFormButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                String name = itemNameEditText.getText().toString();
                String items = quantityEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String phone = phoneNumEditText.getText().toString();
                String date = dateEditText.getText().toString();
                String notes = noteEditText.getText().toString();
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                String category = radioButton.getText().toString();

                Intent intent = new Intent(DonationForm.this,DonationSummary.class);
                intent.putExtra("Name", name);
                intent.putExtra("Quantity", items);
                intent.putExtra("Notes", notes);
                intent.putExtra("Address", address);
                intent.putExtra("Phone Number", phone);
                intent.putExtra("Date", date);
                intent.putExtra("Category", category);

                startActivity(intent);
            }
        });



    }

   /* public void launchFormSummary(View view) {
        Log.d(LOG_TAG, "Form submittion button clicked!");

        Intent intent = new Intent(this,DonationSummary.class);
        startActivity(intent);
    } */

    public void checkCategoryButton(View v) { //variable for which category is selected
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        //Toast.makeText(context: this, "Selected category: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

}