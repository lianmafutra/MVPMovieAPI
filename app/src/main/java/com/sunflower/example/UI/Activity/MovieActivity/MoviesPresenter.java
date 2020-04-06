package com.sunflower.example.UI.Activity.MovieActivity;

import android.content.Context;

import androidx.annotation.NonNull;

import com.sunflower.example.Data.Model.ResponseMovie;
import com.sunflower.example.Network.Interface.MovieInterfaceApi;
import com.sunflower.example.Network.Retrofit.RetroServer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.provider.MediaStore.Video.VideoColumns.LANGUAGE;
import static com.sunflower.example.Network.API.MovieConfig.API_KEY;

public class MoviesPresenter implements MoviesContract.UserActionListener {

    private MovieInterfaceApi api;
    private Context context;
    MoviesContract.View view;

    public MoviesPresenter(MoviesContract.View view2, Context context) {
        this.view      = view2;
        this.context   = context;
        api            = RetroServer.getClient().create(MovieInterfaceApi.class);
    }

    public void delete(int id) {
        view.onSucces("true");
    }

    @Override
    public void loadMoviePage(int page) {
        Call<ResponseMovie> call = api.getPopularMovies(API_KEY, LANGUAGE, page);
        call.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(@NonNull Call<ResponseMovie> call, @NonNull Response<ResponseMovie> response) {
                if (response.isSuccessful()) {
                    ResponseMovie moviesResponse = response.body();
                    if (moviesResponse != null && moviesResponse.getResults() != null) {
                        view.getMovie(moviesResponse.getResults());
                    } else {
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {
                view.onError(t.toString());
            }
        });
    }
}
