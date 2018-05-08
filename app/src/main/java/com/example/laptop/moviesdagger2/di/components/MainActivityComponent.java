package com.example.laptop.moviesdagger2.di.components;

import com.example.laptop.moviesdagger2.main.MainActivity;
import com.example.laptop.moviesdagger2.di.scopes.ActivityScope;
import com.example.laptop.moviesdagger2.di.modules.MainActivityModule;

import dagger.Component;

@ActivityScope
@Component(modules = MainActivityModule.class, dependencies = MoviesDagger2Component.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);
}
