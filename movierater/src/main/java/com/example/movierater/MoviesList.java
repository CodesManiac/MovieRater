package com.example.movierater;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class MoviesList extends AppCompatActivity {

    GridView gridView;
    ArrayList<Movies>list;
    MoviesAdapter adapter=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list_activity);

        gridView=findViewById(R.id.gridView);
        list=new ArrayList<>();
        adapter=new MoviesAdapter(this,R.layout.image_items,list);
        gridView.setAdapter(adapter);

        //getting data from database
        Cursor cursor = AddMovies.sqliteHelper.getData("SELECT * FROM MoviesTable");
        list.clear();
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String name =cursor.getString(1);
            String category=cursor.getString(2);
            String description = cursor.getString(3);
            byte[] image =cursor.getBlob(4);

            list.add(new Movies(id,name,category,description,image));
        }
        adapter.notifyDataSetChanged();

    }
}
