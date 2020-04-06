package com.sunflower.example.Network.Interface;

import com.sunflower.example.Data.Model.ResponseMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import static com.sunflower.example.Network.API.ApiEndPoint.LIST_MOVIE_POPULER;

public interface MovieInterfaceApi {
    @GET(LIST_MOVIE_POPULER)
    Call<ResponseMovie> getPopularMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );
}
