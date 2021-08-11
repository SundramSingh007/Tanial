package com.sundram.retrofit.interfaces;

import com.sundram.retrofit.models.UserDataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("users")
    Call<UserDataModel> getPosts(@Query("page") Integer page_no);
}
