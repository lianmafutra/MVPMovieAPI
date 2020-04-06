package com.sunflower.example.UI.Activity.MovieActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.sunflower.example.Data.Model.ResultsItemMovie;
import com.sunflower.example.R;
import com.sunflower.example.UI.Adapter.MoviesAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieActivity extends AppCompatActivity implements MoviesContract.View, SwipeRefreshLayout.OnRefreshListener {

    private MoviesAdapter adapter;
    private MoviesPresenter moviesRepository;

    @BindView(R.id.progressBar)
    ProgressBar loading;
    @BindView(R.id.rv_movie)
    RecyclerView rv_movie;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);

        //init
        moviesRepository = new MoviesPresenter(this,this);
        swipeRefresh.setOnRefreshListener(this);
        rv_movie.setLayoutManager(new LinearLayoutManager(this));

        //action
        moviesRepository.loadMoviePage(1);
        moviesRepository.delete(12);
    }


    @Override
    public void getMovie(List<ResultsItemMovie> movies) {
        adapter = new MoviesAdapter(movies);
        rv_movie.setAdapter(adapter);
        hideProgress();
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void showProgress() {
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        loading.setVisibility(View.GONE);
    }

    @Override
    public void onSucces(String status) {
        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String status) {
        Toast.makeText(this, "gagal = "+status, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        moviesRepository.loadMoviePage(1);
        Toast.makeText(MovieActivity.this, "Memperbarui Data", Toast.LENGTH_SHORT).show();
    }
}
