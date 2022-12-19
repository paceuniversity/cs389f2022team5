package com.example.instagive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DonationForm extends AppCompatActivity {

    private static final String LOG_TAG = DonationForm.class.getSimpleName();
    private EditText phoneNumEditText;
    private String phone, quantity, items, address, date, notes, category, itemName,time,username, ogPhone;
    RadioGroup radioGroup;
    RadioButton radioButton;
    private Bundle form;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_form);
        reference = FirebaseDatabase.getInstance().getReference("users");
        radioGroup = findViewById(R.id.radioGroup);
        TextView textViewTitle = findViewById(R.id.textFormTitle);
        TextView textViewDescription = findViewById(R.id.textFormDescription);
        TextView textViewCategory = findViewById(R.id.textFormCategory);
        phoneNumEditText = (EditText) findViewById(R.id.inputFormPhoneNum);
        Intent intent = getIntent();
        //String name = intent.getStringExtra("name");
        username = intent.getStringExtra("username");
        phone = intent.getStringExtra("phone");
        ogPhone = phone;
        showData();

        EditText itemNameEditText = (EditText) findViewById(R.id.inputNameOfItem);

        EditText quantityEditText = (EditText) findViewById(R.id.inputQuantity);

        EditText addressEditText = (EditText) findViewById(R.id.inputFormPickupAddress);

        EditText dateEditText = (EditText) findViewById(R.id.inputFormDate);

        EditText noteEditText = (EditText) findViewById(R.id.inputMultiLineNotes);

        Spinner spinnerTime =findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.pickupTime, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerTime.setAdapter(adapter);
        Button submitFormButton = findViewById(R.id.buttonSubmitForm);

        submitFormButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                 itemName = itemNameEditText.getText().toString();
                 items = quantityEditText.getText().toString();
                 address = addressEditText.getText().toString();
                 phone = phoneNumEditText.getText().toString();
                 date = dateEditText.getText().toString();
                 notes = noteEditText.getText().toString();
                int radioId = radioGroup.getCheckedRadioButtonId();
                if (radioId == -1)
                    Toast.makeText(DonationForm.this, "Please select a category!", Toast.LENGTH_SHORT).show();
                else {

                    radioButton = findViewById(radioId);
                     category = radioButton.getText().toString();

                     time = spinnerTime.getSelectedItem().toString();

                     form = getIntent().getExtras();
                   // form.putString("name", name);
                    form.putString("Item_Name", itemName);
                    form.putString("Quantity", items);
                    form.putString("Notes", notes);
                    form.putString("Address", address);
                    form.putString("phone", phone);
                    form.putString("Date", date);
                    form.putString("Category", category);
                    form.putString("Time", time);


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
                    } else if (time.equals("Time")) {
                        Toast.makeText(DonationForm.this, "Please select a pickup time!", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(DonationForm.this, Destination.class);
                        intent.putExtras(form);
                        startActivity(intent);
               /* intent.putExtra("Name", name);
                intent.putExtra("Quantity", items);
                intent.putExtra("Notes", notes);
                intent.putExtra("Address", address);
                intent.putExtra("Phone Number", phone);
                intent.putExtra("Date", date);
                intent.putExtra("Category", category); */


                    }
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

    public void showData(){

        phoneNumEditText.setText(phone);

    }

}