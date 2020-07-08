package com.example.movierater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToSignupPage(View view){
        Intent intent = new Intent(this,SignUpPage.class);
        startActivity(intent);
    }
    public void goToAdminMoviesInput(View view){
        Intent intent = new Intent(this,AddMovies.class);
        startActivity(intent);
    }
    public void goToHomePage(View view){
        Intent intent = new Intent(this,HomePage.class);
        startActivity(intent);
    }
    public void goToMain2(View view){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

}
