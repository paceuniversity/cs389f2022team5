package com.example.instagive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class DonationForm extends AppCompatActivity {

    private static final String LOG_TAG = DonationForm.class.getSimpleName();

    RadioGroup radioGroup;
    RadioButton radioButton;
    private Bundle form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_form);

        radioGroup = findViewById(R.id.radioGroup);
        TextView textViewTitle = findViewById(R.id.textFormTitle);
        TextView textViewDescription = findViewById(R.id.textFormDescription);
        TextView textViewCategory = findViewById(R.id.textFormCategory);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");

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
            public void onClick(View view) {
                String itemName = itemNameEditText.getText().toString();
                String items = quantityEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String phone = phoneNumEditText.getText().toString();
                String date = dateEditText.getText().toString();
                String notes = noteEditText.getText().toString();
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                String category = radioButton.getText().toString();

                form = new Bundle();
                form.putString("Name", name);
                form.putString("Item_Name", itemName);
                form.putString("Quantity", items);
                form.putString("Notes", notes);
                form.putString("Address", address);
                form.putString("Phone Number", phone);
                form.putString("Date", date);
                form.putString("Category", category);


                if (TextUtils.isEmpty(itemName)) { //making fields required. Checking if empty
                    itemNameEditText.setError("Item name is required!");
                } else if (TextUtils.isEmpty(items)) {
                    quantityEditText.setError("Quantity of the item is required!");
                } else if (TextUtils.isEmpty(address)) {
                    addressEditText.setError("Your pickup address is required!");
                } else if (TextUtils.isEmpty(phone)) {
                    phoneNumEditText.setError("Phone number is required!");
                } else if (TextUtils.isEmpty(date)) {
                    dateEditText.setError("Date is required!");
                //} else if (TextUtils.isEmpty(category)) {
                    //textViewCategory.setError("A category must be selected!");
                }else{
                    Intent intent = new Intent(DonationForm.this, Destination.class);
                    intent.putExtras(form);

               /* intent.putExtra("Name", name);
                intent.putExtra("Quantity", items);
                intent.putExtra("Notes", notes);
                intent.putExtra("Address", address);
                intent.putExtra("Phone Number", phone);
                intent.putExtra("Date", date);
                intent.putExtra("Category", category); */

                    startActivity(intent);
                }
            }
        });



    }

   /* public void launchFormSummary(View view) {

       Log.d(LOG_TAG, "Form submittion button clicked!");
        EditText quantityEditText = (EditText) findViewById(R.id.inputQuantity);
        String quantity = quantityEditText.getText().toString();

        EditText addressEditText = (EditText) findViewById(R.id.inputFormPickupAddress);
        String pickupAddress = addressEditText.getText().toString();

        EditText phoneNumEditText = (EditText) findViewById(R.id.inputFormPhoneNum);
        String phoneNum = phoneNumEditText.getText().toString();

        EditText dateEditText = (EditText) findViewById(R.id.inputFormDate);
        String date = dateEditText.getText().toString();

        EditText noteEditText = (EditText) findViewById(R.id.inputMultiLineNotes);
        String note = noteEditText.getText().toString();

        Button submitFormButton = findViewById(R.id.buttonSubmitForm);

    }

    public void launchFormSummary(View view) {

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