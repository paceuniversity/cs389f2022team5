package com.example.instagive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.EditText;

public class Confirmation extends AppCompatActivity {


        // RadioGroup radioGroup;


        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_confirmation);

            Intent intent = getIntent();
            String user_name = intent.getStringExtra("Name");
            String item_name = intent.getStringExtra("Item_Name");
            String quantity = intent.getStringExtra("Quantity");
            String address = intent.getStringExtra("Address");
            String cell = intent.getStringExtra("Phone Number");
            String date = intent.getStringExtra("Date");
            String note = intent.getStringExtra("Notes");
            String category = intent.getStringExtra("Category");
            String pickUP = intent.getStringExtra("Pick Up");
            String organization = intent.getStringExtra("Organization");
            TextView result = findViewById(R.id.result);
            result.setText("Name: " + user_name + "\nItem Name: "+item_name+"\nCategory: " + category + "\nQuantity: " + quantity + "\nAddress: " + pickUP + "\nPhone Number: " + cell + "\nDate: " + date + "\nNotes: " + note + "\nDestination: " + organization);

            TextView paragraph = findViewById(R.id.paragraph);
            paragraph.setText("Thank you " +user_name+ ", for your donation towards the " +organization+ ". You will be receiving updates, via the cell number provided, 1-2 days prior to your requested date.\nFor more information on your chosen organization, please continue below.");
            Button submitFormButton = findViewById(R.id.aboutButton);

            submitFormButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(Confirmation.this, Learn.class);
                    Bundle mBundle = new Bundle();
                    mBundle = getIntent().getExtras();
                    intent.putExtras(mBundle);
                    //String pickup = address;
                    //intent.putExtra("Pick Up", pickup);
                    startActivity(intent);
                }
            });



       /* TextView nameView = findViewById(R.id.NameForm);
        nameView.setText(user_name);

        TextView itemView = findViewById(R.id.ItemForm);
        itemView.setText(quantity);

        TextView addressView = findViewById(R.id.AddressForm);
        addressView.setText(address);

        TextView cellView = findViewById(R.id.CellForm);
        cellView.setText(cell);

        TextView dateView = findViewById(R.id.DateForm);
        dateView.setText(date);

        TextView noteView = findViewById(R.id.NoteForm);
        noteView.setText(note);

        TextView textView = findViewById(R.id.textView3);
        textView.setText("Hello");
*/

        }

}