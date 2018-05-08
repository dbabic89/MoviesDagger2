package com.example.laptop.moviesdagger2.di.modules;

import android.content.Context;

import com.example.laptop.moviesdagger2.di.scopes.MoviesAppScope;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module(includes = {ApplicationModule.class, NetworkModule.class})
public class PicassoModule {

    @Provides
    @MoviesAppScope
    Picasso picasso(Context context, OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides
    @MoviesAppScope
    OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }
}