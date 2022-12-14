package com.example.instagive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class DonationSummary extends AppCompatActivity {
   // RadioGroup radioGroup;
   DatabaseReference reference;
    private int dono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_summary);
        reference = FirebaseDatabase.getInstance().getReference("users");
        Intent intent = getIntent();
        String nameDB = intent.getStringExtra("username");
        String user_name = intent.getStringExtra("name");
        String item_name = intent.getStringExtra("Item_Name");
       String quantity = intent.getStringExtra("Quantity");
        String address = intent.getStringExtra("Address");
        String cell = intent.getStringExtra("phone");
       String date = intent.getStringExtra("Date");
        String note = intent.getStringExtra("Notes");
        String category = intent.getStringExtra("Category");
        String pickUP = intent.getStringExtra("Pick Up");
        String organization = intent.getStringExtra("Organization");
        String time = intent.getStringExtra("Time");
        dono = intent.getIntExtra("donations",0);
      //  String userUsername = profileUsername.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("userName").equalTo(nameDB);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){

                   dono = snapshot.child(nameDB).child("donations").getValue(Integer.class);


                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

       TextView result = findViewById(R.id.result);
       result.setText("Name: " +user_name+"\nItem Name: "+item_name+"\nCategory: "+category+"\nQuantity: "+quantity+"\nAddress: "+pickUP+"\nPhone Number: "+cell+"\nDate: "+date+"\nPickup Time: "+time+"\nNotes: "+note+"\nDestination: "+organization);

        Button submitFormButton = findViewById(R.id.destinationButton);

        submitFormButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view){
                   reference.child(nameDB).child("donations").setValue(dono+1);
                    dono = dono+1;
                    String donoTitle = "Donation " +dono+": "+item_name;
                    donationClass donation = new donationClass(user_name,cell,pickUP,nameDB,date,item_name,note,time, donoTitle,organization);
                    reference.child(nameDB).child("history").child(donoTitle).setValue(donation);
                   // reference.child(nameDB).child("history").child(donoTitle).push().setValue(donation);

                Intent intent = new Intent(DonationSummary.this,Confirmation.class);
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