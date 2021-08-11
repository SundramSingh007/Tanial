package com.sundram.mvvm.networ_utils;

import com.sundram.mvvm.model.MovieResult;

import retrofit2.Response;

public interface APIResponseInterface {
    void onResponse(Response<MovieResult> response);
    void onError(String error);
}
