package com.example.laptop.moviesdagger2;

import android.app.Activity;
import android.app.Application;

import com.example.laptop.moviesdagger2.di.components.DaggerMoviesDagger2Component;
import com.example.laptop.moviesdagger2.di.modules.ApplicationModule;
import com.example.laptop.moviesdagger2.di.components.MoviesDagger2Component;

public class MoviesDagger2 extends Application {

    private MoviesDagger2Component moviesDagger2Component;

    public static MoviesDagger2 getMoviesNoDagger2(Activity activity) {
        return (MoviesDagger2) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        moviesDagger2Component = DaggerMoviesDagger2Component.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public MoviesDagger2Component getComponent() {
        return moviesDagger2Component;
    }

}
