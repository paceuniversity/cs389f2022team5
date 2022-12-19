package com.example.instagive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Destination extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    RadioGroup radioGroup;
    RadioButton radioButton;
    private String pickUP;
    private Spinner spinnerOrganizations;
    private ImageView photo;
    private String [] organizations = {"American Red Cross","Salvation Army", "Feeding America","YMCA of the USA", "Boys and Girls Club of America", "Ronald McDonald House Charities", "ASPCA"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        //radioGroup = findViewById(R.id.radioGroup);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String address = intent.getStringExtra("Address");
        pickUP = address;
        photo = findViewById(R.id.imageView5);
         spinnerOrganizations =findViewById(R.id.spinner_organizations);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, organizations);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerOrganizations.setAdapter(adapter);
        spinnerOrganizations.setOnItemSelectedListener(this);
        //String selection = "American Red Cross";
        //int spinnerPosition = adapter.getPosition(selection);
       // spinnerOrganizations.setSelection(spinnerPosition);



        //RadioButton pickup = (RadioButton)findViewById(R.id.radioButtonPickUp);
        //pickup.setText(address);




       /* spinnerOrganizations.setOnItemClickListener( new AdapterView.OnItemClickListener()
                                                     {
                                                         @Override
                                                         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        }






                                                         }

                                                     }
        ); */

        Button submitDestinationButton = findViewById(R.id.buttonSubmitForm);


         submitDestinationButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                //int radioId = radioGroup.getCheckedRadioButtonId();
                //radioButton = findViewById(radioId);
                //String pickUP = radioButton.getText().toString();
                String organization = spinnerOrganizations.getSelectedItem().toString();
                if(organization.equals("Select Organization"))
                {
                    Toast.makeText(Destination.this, "Please select an organization!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                Intent intent = new Intent(Destination.this,DonationSummary.class);
                Bundle form = new Bundle();
                form = getIntent().getExtras();
                form.putString("Pick Up", pickUP);
                form.putString("Organization" , organization);
                intent.putExtras(form);
                startActivity(intent); }
            }
        });


    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // on below line we are displaying toast message for selected item
        Toast.makeText(Destination.this, "" + organizations[position] + " Selected..", Toast.LENGTH_SHORT).show();
        String uri;
        int imageResource;
        Drawable res;
        switch (organizations[position]) {
            case "American Red Cross":
                uri = "@drawable/americanrc";
                imageResource = getResources().getIdentifier(uri, null, getPackageName());
                res = getResources().getDrawable(imageResource);
                photo.setImageDrawable(res);
                break;

            case "Salvation Army":
                 uri = "@drawable/salvationarmy";
                imageResource = getResources().getIdentifier(uri, null, getPackageName());
                res = getResources().getDrawable(imageResource);
                photo.setImageDrawable(res);
                break;

            case "Feeding America":
                uri = "@drawable/feedingamerica";
                imageResource = getResources().getIdentifier(uri, null, getPackageName());
                res = getResources().getDrawable(imageResource);
                photo.setImageDrawable(res);
                break;

            case "YMCA of the USA":
                uri = "@drawable/ymca";
                imageResource = getResources().getIdentifier(uri, null, getPackageName());
                res = getResources().getDrawable(imageResource);
                photo.setImageDrawable(res);
                break;

            case "Boys and Girls Club of America":
                uri = "@drawable/bgca";
                imageResource = getResources().getIdentifier(uri, null, getPackageName());
                res = getResources().getDrawable(imageResource);
                photo.setImageDrawable(res);
                break;

            case "Ronald McDonald House Charities":
                uri = "@drawable/rmhc";
                imageResource = getResources().getIdentifier(uri, null, getPackageName());
                res = getResources().getDrawable(imageResource);
                photo.setImageDrawable(res);
                break;

            case "ASPCA":
                uri = "@drawable/aspca";
                imageResource = getResources().getIdentifier(uri, null, getPackageName());
                res = getResources().getDrawable(imageResource);
                photo.setImageDrawable(res);
                break;

            default:
                uri = "@drawable/instagive";
                imageResource = getResources().getIdentifier(uri, null, getPackageName());
                res = getResources().getDrawable(imageResource);
                photo.setImageDrawable(res);
                break;


        }

    }
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



    public void checkCategoryButton(View v) { //variable for which category is selected
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);



       // Toast.makeText(context: this, "Selected category: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}