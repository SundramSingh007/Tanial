package com.sundram.mvvm.retrofit_service;

import com.sundram.mvvm.model.MovieResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIServices {

    @GET("movie")
    Call<MovieResult> getAllMoviesByKeyWord(
            @Query("api_key") String api_key,
            @Query("language") String lang,
            @Query("query") String keyword
    );

}
