package com.example.instagive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Contact extends AppCompatActivity {
    private TextView link, insta, faceb, discord, email, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        insta = findViewById(R.id.editInstagram);
        faceb = findViewById(R.id.editFB);
        discord = findViewById(R.id.editDiscord);
        email = findViewById(R.id.editEmail);
        address = findViewById(R.id.editAddress);
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        link = findViewById(R.id.editInstagram);
                        setLink("https://instagram.com/instaglve?igshid=Nzg3NjI1NGI=");
            }
        });

        faceb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link = findViewById(R.id.editFB);
                setLink("https://www.facebook.com/profile.php?id=100088551435711");
            }
        });

        discord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link = findViewById(R.id.editDiscord);
                setLink("https://discord.gg/xzDDKStQMH");
            }
        });

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link = findViewById(R.id.editAddress);
                setLink("https://goo.gl/maps/r1L8VLgVmdQzPeeU7");
            }
        });

       /* email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:instagive2022@gmail.com?subject=" + Uri.encode("subject") + "&body=" + Uri.encode(""));
                intent.setData(data);
                startActivity(intent);
            }
        }); */



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

    //  result.setText("\nEmail: instagive2022@gmail.com\n \nPhone: 1-800-instagive\n \nMailing Address: One Pace Plaza New York, NY 10083\n \nSocials: @instaglve");



