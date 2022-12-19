package com.example.instagive;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

public class History extends AppCompatActivity{
    ListView listView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("users").child(username).child("history");


        listView = (ListView) findViewById(R.id.idLVDonations);


        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Map<String, donationClass> map = (Map<String, donationClass>) dataSnapshot.getValue();
                String title = map.toString();


               // String value = dataSnapshot.child(title).getValue(donationClass.class).toString();
                arrayList.add(title);
                arrayAdapter = new ArrayAdapter<String>(History.this, android.R.layout.simple_list_item_1, arrayList);
                listView.setAdapter(arrayAdapter);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }}




/*
public class History extends AppCompatActivity {

    // creating variables for our list view.
    private ListView donationsLV;
    private String username;
    // creating a new array list.
    ArrayList<String> donationsArrayList;

    // creating a variable for database reference.
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Intent intent = getIntent();
         username = intent.getStringExtra("username");
        // initializing variables for listviews.
        donationsLV = findViewById(R.id.idLVDonations);

        // initializing our array list
        donationsArrayList = new ArrayList<String>();
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
         donationsLV.setAdapter(adapter);

        // below line is used for getting reference
        // of our Firebase Database.
        reference = FirebaseDatabase.getInstance().getReference("users");

        // in below line we are calling method for add child event
        // listener to get the child of our database.
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                // this method is called when new child is added to
                // our data base and after adding new child
                // we are adding that item inside our array list and
                // notifying our adapter that the data in adapter is changed.
                String test = snapshot.getValue(userClass.class).toString();
                String value = snapshot.child(username).child("history").getValue(String.class);
                donationsArrayList.add(test);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                // this method is called when the new child is added.
                // when the new child is added to our list we will be
                // notifying our adapter that data has changed.
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                // below method is called when we remove a child from our database.
                // inside this method we are removing the child from our array list
                // by comparing with it's value.
                // after removing the data we are notifying our adapter that the
                // data has been changed.
                donationsArrayList.remove(snapshot.child(username).child("history").getValue(String.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                // this method is called when we move our
                // child in our database.
                // in our code we are note moving any child.
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // this method is called when we get any
                // error from Firebase with error.
            }
        });
        // below line is used for setting
        // an adapter to our list view.
        //donationsLV.setAdapter(adapter);
        // calling a method to get data from
        // Firebase and set data to list view
       // initializeListView();
    }

    private void initializeListView() {
        // creating a new array adapter for our list view.

    }
}
*/