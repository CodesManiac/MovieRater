package com.example.movierater;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

public class SqliteHelper extends SQLiteOpenHelper {
    private static  String DATABASE_NAME ="MoviesDb.db";
    private static int DATABASE_VERSION =1;
    private String createTableQuery="create table MoviesTable(MovieId INTEGER PRIMARY KEY AUTOINCREMENT," +
            "MovieName TEXT,MovieCategory TEXT," +
            "MovieDescription TEXT,MovieImage BLOB)";

    private Context context;


    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }
    public void queryData(String sql){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
    }
    public void insertData(String movieName,String movieCategory,String movieDescription, byte[] movieImage){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql ="INSERT INTO MoviesTable VALUES(null,?,?,?,?)";
        SQLiteStatement statement=sqLiteDatabase.compileStatement(sql);
        statement.bindString(1,movieName);
        statement.bindString(2,movieCategory);
        statement.bindString(3,movieDescription);
        statement.bindBlob(4,movieImage);
        statement.executeInsert();
    }
    public Cursor getData(String sql){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql,null);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(createTableQuery);
            Toast.makeText(context, "Table created successfully", Toast.LENGTH_LONG).show();

        }catch (Exception e){
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
