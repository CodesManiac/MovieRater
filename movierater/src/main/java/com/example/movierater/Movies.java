package com.example.movierater;

public class Movies {
    private int id;
    private String movieName,movieCategory,movieDescription;
    private byte[]movieImage;

    public Movies(int id, String movieName, String movieCategory, String movieDescription, byte[] movieImage) {
        this.id = id;
        this.movieName = movieName;
        this.movieCategory = movieCategory;
        this.movieDescription = movieDescription;
        this.movieImage = movieImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public byte[] getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(byte[] moveImage) {
        this.movieImage = moveImage;
    }
}
