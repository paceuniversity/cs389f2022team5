package com.example.instagive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Learn extends AppCompatActivity {
private Button link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        Intent intent = getIntent();
        String organization = intent.getStringExtra("Organization");
        TextView title = findViewById(R.id.textEditTitle);
        title.setText(organization);
        link = findViewById(R.id.link);
        link.setText(organization);
        TextView result = findViewById(R.id.result);



        switch (organization) {
            case "American Red Cross":
                result.setText("The American Red Cross is an organization that does work around the globe to provide vital services from providing relief and support to this in crisis to emergency preparation\n\n Mission Statement: \nThe American Red Cross prevents and alleviates human suffering in the face of emergencies by mobilizing the power of volunteers and the generosity of donors. \n \nA link to their website with more information can be accessed by clicking the learn more button below.   ");
                    setLink("https://www.redcross.org/");
                break;

            case "Salvation Army":
                result.setText("The Salvation army is a non-profit organization that cares for the homeless and needy as well as 30 million others through several services\n\nMission Statement: \n The Salvation Army, an international movement, is an evangelical part of the universal Christian Church. Its message is based on the Bible. Its ministry is motivated by the love of God. Its mission is to preach the gospel of Jesus Christ and to meet human needs in His name without discrimination.\n\n A link to their website with more information can be accessed by clicking the learn more button below.  ");
                setLink("https://www.salvationarmyusa.org/usn/");
                break;

            case "Feeding America":
                result.setText("Feeding America is a nationwide network of 200 food banks and 60,000 food pantries and meal programs, supporting over 40 million people annually.\n\n Mission Statement: \nOur mission is to advance change in America by ensuring equitable access to nutritious food for all in partnership with food banks, policymakers, supporters, and the communities we serve.\n\nA link to their website with more information can be accessed by clicking the learn more button below.  ");
                setLink("https://www.feedingamerica.org/");
                break;

            case "YMCA of the USA":
                result.setText("The YCMA of the USA is a notable non-profit organization across the country\n\nMission Statement: \n To put Christian principles into practice through programs that build healthy spirit, mind and body for all.\n\nA link to their website with more information can be accessed by clicking the learn more button below.");
                setLink("https://www.ymca.org/");
                break;

            case "Boys and Girls Club of America":
                result.setText("The Boys and Girls Club of America is an organization that provides youth from all walks of life with opportunities for a better future as well as a safe haven today.\n\n Mission Statement: \nTo enable all young people, especially those who need us most, to reach their full potential as productive, caring, responsible citizens. \n\nA link to their website with more information can be accessed by clicking the learn more button below.");
                setLink("https://bgca.org/");
                break;

            case "Ronald McDonald House Charities":
                result.setText("Ronald McDonald House Charities is an organization that mainly provides support to families to stay close with children who are in the hospital due to sickness, providing monetary support, housing, meals and even resources for siblings and outpatients.\n\n Mission Statement: \nThe mission of RMHC is to create, find, and support programs that directly improve the health and well-being of children and their families.\n\nA link to their website with more information can be accessed by clicking the learn more button below.");
                setLink("https://rmhc.org/");
                break;

            case "ASPCA":
                result.setText("The Boys and Girls Club of America is an organization that provides youth from all walks of life with opportunities for a better future as well as a safe haven today.\n\n Mission Statement: \nTo enable all young people, especially those who need us most, to reach their full potential as productive, caring, responsible citizens. \n\nA link to their website with more information can be accessed by clicking the learn more button below.");
                setLink("https://www.aspca.org/");
                break;

            default:
                result.setText("This page will display information about the chosen organization of the user, in this case that was: " + organization);
                break;
        }



   // result.setText("This page will display information about the chosen organization of the user, in this case that was: " + organization);
         Button returnButton = findViewById(R.id.returnHome);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent home = new Intent(Learn.this, MainActivity.class);
                Bundle mBundle = new Bundle();
                mBundle = getIntent().getExtras();
                home.putExtras(mBundle);
                //String pickup = address;
                //intent.putExtra("Pick Up", pickup);
                startActivity(home);
            }
        });
    }
    public void setLink(String s)
    {
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLink(s);
            }
        });
    }

    public void goLink(String s)
    {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }




}