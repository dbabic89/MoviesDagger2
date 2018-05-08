package com.example.laptop.moviesdagger2.di.components;

import com.example.laptop.moviesdagger2.data.TmdbInterface;
import com.example.laptop.moviesdagger2.di.scopes.MoviesAppScope;
import com.example.laptop.moviesdagger2.di.modules.PicassoModule;
import com.example.laptop.moviesdagger2.di.modules.RetrofitModule;
import com.squareup.picasso.Picasso;

import dagger.Component;

@MoviesAppScope
@Component(modules = {PicassoModule.class, RetrofitModule.class})
public interface MoviesDagger2Component {

    TmdbInterface getTmdbInterface();

    Picasso getPicasso();
}
