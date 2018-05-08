package com.example.laptop.moviesdagger2.di.modules;

import com.example.laptop.moviesdagger2.data.TmdbInterface;
import com.example.laptop.moviesdagger2.di.scopes.MoviesAppScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = NetworkModule.class)
public class RetrofitModule {

    @Provides
    @MoviesAppScope
    TmdbInterface tmdbService(Retrofit retrofit) {
        return retrofit.create(TmdbInterface.class);
    }

    @Provides
    @MoviesAppScope
    Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @MoviesAppScope
    Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

}
