package com.sunflower.example.UI.Activity.MovieActivity;

import com.sunflower.example.Data.Model.ResultsItemMovie;

import java.util.List;

public interface MoviesContract {

    interface View {
        void showProgress();
        void hideProgress();
        void onSucces(String status);
        void onError(String status);
        void getMovie(List<ResultsItemMovie> movies);
    }

    interface UserActionListener {
        void loadMoviePage(final int page);
    }
}
