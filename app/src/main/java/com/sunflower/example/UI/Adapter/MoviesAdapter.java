package com.sunflower.example.UI.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sunflower.example.Data.Model.ResultsItemMovie;
import com.sunflower.example.R;
import com.sunflower.example.Utils.image.glide.ImageHelper;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<ResultsItemMovie> movies;

    public MoviesAdapter(List<ResultsItemMovie> movies) {
        this.movies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img_movie;

        public MovieViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            img_movie = itemView.findViewById(R.id.img_movie);

        }

        public void bind(ResultsItemMovie movie) {
            title.setText("http://image.tmdb.org/t/p/w500"+movie.getPosterPath());
            ImageHelper.loadImage(img_movie,"http://image.tmdb.org/t/p/w500"+movie.getPosterPath());
        }
    }
}