package com.example.laptop.moviesdagger2.main;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.laptop.moviesdagger2.BuildConfig;
import com.example.laptop.moviesdagger2.MoviesDagger2;
import com.example.laptop.moviesdagger2.R;
import com.example.laptop.moviesdagger2.data.TmdbInterface;
import com.example.laptop.moviesdagger2.di.components.DaggerMainActivityComponent;
import com.example.laptop.moviesdagger2.models.MovieListResponse;
import com.example.laptop.moviesdagger2.models.MovieListResult;
import com.example.laptop.moviesdagger2.di.components.MainActivityComponent;
import com.example.laptop.moviesdagger2.di.modules.MainActivityModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    MoviesAdapter moviesAdapter;

    @Inject
    TmdbInterface tmdbInterface;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.recycler_view_movies)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createComponent();
        ButterKnife.bind(this);

        progressBar.setVisibility(View.VISIBLE);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(moviesAdapter);

        Call<MovieListResponse> call = tmdbInterface.getPopularMovies(BuildConfig.TMDB_APIKEY, "en-US", 1);
        call.enqueue(new Callback<MovieListResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieListResponse> call, @NonNull Response<MovieListResponse> response) {
                if (response.body() != null) {
                    List<MovieListResult> movies = response.body().getResults();
                    moviesAdapter.addAll(movies);
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(@NonNull Call<MovieListResponse> call, @NonNull Throwable t) {
                Log.e("TAG", t.toString());
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void createComponent() {
        MainActivityComponent mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .moviesDagger2Component(MoviesDagger2.getMoviesNoDagger2(this).getComponent())
                .build();

        mainActivityComponent.inject(this);
    }
}
