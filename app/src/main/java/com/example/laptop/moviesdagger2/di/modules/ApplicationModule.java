package com.example.laptop.moviesdagger2.di.modules;

import android.content.Context;

import com.example.laptop.moviesdagger2.MoviesDagger2;
import com.example.laptop.moviesdagger2.di.scopes.MoviesAppScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final MoviesDagger2 application;

    public ApplicationModule(MoviesDagger2 application) {
        this.application = application;
    }

    @Provides
    @MoviesAppScope
    Context provideApplicationContext() {
        return this.application;
    }
}
