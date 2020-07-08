package com.example.movierater.data;

import android.provider.BaseColumns;

public final class MovieRaterContract {
    private MovieRaterContract(){}

    public static class MovieRaterEntry implements BaseColumns {
        public static final String USER_DETAILS = "UserDetails";
        public static final String COLUMN_NAME_USER_ID = "UserId";
        public static final String COLUMN_NAME_FIRST_NAME = "FirstName";
        public static final String COLUMN_NAME_LAST_NAME = "LastName";
        public static final String COLUMN_NAME_USER_NAME = "UserName";
        public static final String COLUMN_NAME_EMAIL_ADDRESS = "EmailAddress";
        public static final String COLUMN_NAME_GENDER = "Gender";
        public static final String COLUMN_NAME_PASSWORD = "Password";

        public static final String MOVIES_TABLE = "MoviesTable";
        public static final String COLUMN_NAME_MOVIE_ID = "MovieId";
        public static final String COLUMN_NAME_MOVIE_TITLE = "MovieTitle";
        public static final String COLUMN_NAME_MOVIE_CATEGORY = "MovieCategory";
        public static final String COLUMN_NAME_MOVIE_DESCRIPTION = "Movie_Description";
    }


}
