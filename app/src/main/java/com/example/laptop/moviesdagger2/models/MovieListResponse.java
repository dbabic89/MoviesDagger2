package com.example.laptop.moviesdagger2.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieListResponse {

    @SerializedName("results")
    @Expose
    private List<MovieListResult> results = null;

    public List<MovieListResult> getResults() {
        return results;
    }
}
