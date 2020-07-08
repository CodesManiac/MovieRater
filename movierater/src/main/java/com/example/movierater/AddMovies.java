package com.example.movierater;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddMovies extends AppCompatActivity {
    private EditText movieName;
    private EditText movieCategory;
    private EditText movieDescription;
    private ImageView movieImage;
    private Button saveImage;
    private Button back ;

    public static SqliteHelper sqliteHelper;

    final int REQUEST_CODE_GALLERY=111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_movies);
        init();

        sqliteHelper=new SqliteHelper(this);
    }
    private void init(){
        movieName=findViewById(R.id.movieNameEditText);
        movieCategory=findViewById(R.id.movieCategoryEditText);
        movieDescription=findViewById(R.id.movieDescriptionEditText);
        movieImage=findViewById(R.id.movieImage);
        saveImage=findViewById(R.id.saveImageButton);
        back=findViewById(R.id.backButton);
    }
    public void selectImage(View view){
        ActivityCompat.requestPermissions(AddMovies.this,new String[]
                {Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_CODE_GALLERY);

    }
    public void saveData(View view){
        try{
            sqliteHelper.insertData(movieName.getText().toString().trim(),movieCategory.getText().
                    toString().trim(), movieDescription.getText().toString().trim(),
                    imageViewToByte(movieImage));
            Toast.makeText(getApplicationContext(),"Movie Details Added Successfully",
                    Toast.LENGTH_LONG).show();
            movieName.setText("");
            movieCategory.setText("");
            movieDescription.setText("");
            movieImage.setImageResource(R.drawable.image);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public  void goBack(View view){
        Intent intent = new Intent(AddMovies.this,MoviesList.class);
        startActivity(intent);
    }

    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()) .getBitmap();
        ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);
        byte[] byteArray =  byteArrayOutputStream.toByteArray();
        return byteArray;

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
         if(requestCode==REQUEST_CODE_GALLERY){
             if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                 Intent intent = new Intent(Intent.ACTION_PICK);
                 intent.setType("image/*");
                 startActivityForResult(intent,REQUEST_CODE_GALLERY);
             }else{
                 Toast.makeText(getApplicationContext(), "You dont have access to the camera of this device'", Toast.LENGTH_SHORT).show();
             }
             return;
         }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==REQUEST_CODE_GALLERY && resultCode==RESULT_OK && data!=null){
            Uri uri=data.getData();
            try {
                InputStream inputStream=getContentResolver().openInputStream(uri);
                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                movieImage.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}
