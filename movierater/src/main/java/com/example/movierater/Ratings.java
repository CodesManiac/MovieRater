package com.example.movierater;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Ratings extends AppCompatActivity {

    private TextView tvName,tvCategory,tvDescription;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

        tvName=findViewById(R.id.ratingsName);
        tvCategory=findViewById(R.id.ratingsCategory);
        tvDescription=findViewById(R.id.ratingsDescription);
        img=findViewById(R.id.ratingsImage);


        Intent intent=getIntent();
        String MovieName =intent.getExtras().getString("MovieName");
        String MovieCategory =intent.getExtras().getString("MovieCategory");
        String MovieDescription =intent.getExtras().getString("MovieDescription");
        byte[] MovieImage =intent.getExtras().getByteArray("MovieImage");


        //set Values in respective fields
        tvName.setText(MovieName);
        tvCategory.setText(MovieCategory);
        tvDescription.setText(MovieDescription);
        Bitmap bitmap= BitmapFactory.decodeByteArray(MovieImage,0,MovieImage.length);
        img.setImageBitmap(bitmap);

    }
}
