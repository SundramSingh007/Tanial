package com.sundram.mvvm.repository;

import com.sundram.mvvm.model.MovieResult;
import com.sundram.mvvm.retrofit_service.APIServices;
import com.sundram.mvvm.utilities.ConstantUtils;

import javax.inject.Inject;

import retrofit2.Call;

public class MovieRepository {

    private final APIServices apiServices;

    @Inject
    public MovieRepository(APIServices apiServices) {
        this.apiServices = apiServices;
    }

    public Call<MovieResult> getAllMoviesByKeyWord(String keyword){
        return apiServices.getAllMoviesByKeyWord(ConstantUtils.API_KEY,ConstantUtils.LANG,keyword);
    }
}
