package com.example.movierater;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import com.example.movierater.data.MovieRaterDatabase;
import com.example.movierater.data.MovieRaterContract.MovieRaterEntry;


public class SignUpPage extends AppCompatActivity {

    EditText firstNameEditText;
    EditText lastNameEditText;
    EditText userNameEditText;
    EditText emailEditText;
    RadioGroup genderGroup;
    RadioButton maleRadioButton;
    RadioButton femaleRadioButton;
    EditText passwordEditText;
    EditText reenterPasswordEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        firstNameEditText=findViewById(R.id.firstName);
        lastNameEditText=findViewById(R.id.lastName);
        userNameEditText=findViewById(R.id.userName);
        emailEditText=findViewById(R.id.email);
        maleRadioButton= findViewById(R.id.maleG);
        femaleRadioButton= findViewById(R.id.femaleG);
        passwordEditText=findViewById(R.id.password);
        reenterPasswordEditText=findViewById(R.id.re_enterPassword);


    }
    private void insertUserInfo(){

        String firstName =firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        String userName = userNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String gender;
        if(femaleRadioButton.isChecked()){
            gender ="Female";
        }else{
            gender="Male";
        }
        String password=passwordEditText.getText().toString().trim();



        MovieRaterDatabase movieDb = new MovieRaterDatabase(this);
        SQLiteDatabase sqlDb =movieDb.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MovieRaterEntry.COLUMN_NAME_FIRST_NAME,firstName );
        values.put(MovieRaterEntry.COLUMN_NAME_LAST_NAME,lastName );
        values.put(MovieRaterEntry.COLUMN_NAME_USER_NAME,userName );
        values.put(MovieRaterEntry.COLUMN_NAME_EMAIL_ADDRESS,email );
        values.put(MovieRaterEntry.COLUMN_NAME_GENDER,gender );
        values.put(MovieRaterEntry.COLUMN_NAME_PASSWORD,password );


        // Insert a new row for pet in the database, returning the ID of that new row.
        long newRowId = sqlDb.insert(MovieRaterEntry.USER_DETAILS, null, values);

        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error while inserting User Details", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Signed up successfully with row id: " + newRowId, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }




    }
    public void registerUser(View view){
        insertUserInfo();
    }
    public void goToLoginPage(View view){
        Intent intent = new Intent(SignUpPage.this,MainActivity.class);
            startActivity(intent);
    }
//    public void validateFields(){
//        if(firstNameEditText.equals("")){
//            Toast.makeText(this, "First Name Field is empty", Toast.LENGTH_SHORT).show();
//        }else if(lastNameEditText.equals("")){
//            Toast.makeText(this, "Last Name Field is empty", Toast.LENGTH_SHORT).show();
//        }else if(userNameEditText.equals("")){
//            Toast.makeText(this, "Username Field is empty", Toast.LENGTH_SHORT).show();
//        }else if(emailEditText.equals("")){
//            Toast.makeText(this, "Email Address Field is empty", Toast.LENGTH_SHORT).show();
//        }else if(passwordEditText.equals("")){
//            Toast.makeText(this, "Password Field is empty", Toast.LENGTH_SHORT).show();
//        }else if(reenterPasswordEditText.equals("")){
//            Toast.makeText(this, "Password Field is empty", Toast.LENGTH_SHORT).show();
//        }
//    }
}
