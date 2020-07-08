package com.example.movierater.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.movierater.data.MovieRaterContract.MovieRaterEntry;
//Helper class
public class MovieRaterDatabase extends SQLiteOpenHelper {
    public static  final String LOG_TAG = MovieRaterDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "MovieRater.db";

    private static final int DATABASE_VERSION = 1;


    public MovieRaterDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_USERS_TABLE =  "CREATE TABLE " +MovieRaterEntry.USER_DETAILS + " ("
                + MovieRaterEntry.COLUMN_NAME_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MovieRaterEntry.COLUMN_NAME_FIRST_NAME + " TEXT NOT NULL, "
                + MovieRaterEntry.COLUMN_NAME_LAST_NAME + " TEXT NOT NULL, "
                + MovieRaterEntry.COLUMN_NAME_USER_NAME + " TEXT NOT NULL, "
                + MovieRaterEntry.COLUMN_NAME_EMAIL_ADDRESS + " TEXT UNIQUE, "
                + MovieRaterEntry.COLUMN_NAME_GENDER + " TEXT DEFAULT '', "
                + MovieRaterEntry.COLUMN_NAME_PASSWORD + " TEXT UNIQUE);";


        String SQL_CREATE_MOVIES_TABLE =  "CREATE TABLE " + MovieRaterContract.MovieRaterEntry.MOVIES_TABLE + " ("
                + MovieRaterContract.MovieRaterEntry.COLUMN_NAME_MOVIE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MovieRaterContract.MovieRaterEntry.COLUMN_NAME_MOVIE_TITLE + " TEXT NOT NULL, "
                + MovieRaterContract.MovieRaterEntry.COLUMN_NAME_MOVIE_CATEGORY + " TEXT, "
                + MovieRaterContract.MovieRaterEntry.COLUMN_NAME_MOVIE_DESCRIPTION + " TEXT NOT NULL);";

        // Execute the SQL statement
        sqLiteDatabase.execSQL(SQL_CREATE_USERS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_MOVIES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
