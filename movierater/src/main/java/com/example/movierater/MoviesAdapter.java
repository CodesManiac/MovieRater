package com.example.movierater;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MoviesAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Movies> moviesList;

    public MoviesAdapter(Context context, int layout, ArrayList<Movies> moviesList) {
        this.context = context;
        this.layout = layout;
        this.moviesList = moviesList;
    }



    @Override
    public int getCount() {
        return moviesList.size();
    }

    @Override
    public Object getItem(int position) {
        return moviesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName,txtCategory,txtDescription;
        CardView cardView;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        View row=view;
        ViewHolder holder = new ViewHolder();

        if(row ==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(layout,null);

            holder.txtName=row.findViewById(R.id.movieNameTextView);
            holder.txtCategory=row.findViewById(R.id.movieCategoryTextView);
//            holder.txtDescription=row.findViewById(R.id.movieDescriptionTextView);
            holder.imageView=row.findViewById(R.id.movieImageView);
            holder.cardView=row.findViewById(R.id.goToRatings);

            row.setTag(holder);

        }else{
            holder=(ViewHolder) row.getTag();
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context,Ratings.class);
                intent.putExtra("MovieName",moviesList.get(position).getMovieName());
                intent.putExtra("MovieCategory",moviesList.get(position).getMovieCategory());
                intent.putExtra("MovieDescription",moviesList.get(position).getMovieDescription());
                intent.putExtra("MovieImage",moviesList.get(position).getMovieImage());
                context.startActivity(intent);
            }
        });
        Movies movies=moviesList.get(position);
        holder.txtName.setText(movies.getMovieName());
        holder.txtCategory.setText(movies.getMovieCategory());
//        holder.txtDescription.setText(movies.getMovieDescription());

        byte[] movieImage=movies.getMovieImage();
        Bitmap bitmap= BitmapFactory.decodeByteArray(movieImage,0,movieImage.length);

        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
    public  void game(){

    }

}
