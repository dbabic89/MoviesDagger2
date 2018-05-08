package com.example.laptop.moviesdagger2.di.modules;

import android.content.Context;

import com.example.laptop.moviesdagger2.main.MainActivity;
import com.example.laptop.moviesdagger2.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    private final MainActivity activity;

    public MainActivityModule(MainActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Context provideActivityContext() {
        return this.activity;
    }
}