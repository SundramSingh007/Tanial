package com.sundram.mvvm.networ_utils;

import android.content.Context;

import com.sundram.mvvm.model.MovieResult;
import com.sundram.mvvm.repository.MovieRepository;
import com.sundram.mvvm.utilities.ConnectionUtils;
import com.sundram.mvvm.utilities.ConstantUtils;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APICall {

    private final MovieRepository repository;
    private final static String TAG = "APICAll";

    @Inject
    public APICall(MovieRepository repository) {
        this.repository = repository;
    }

    public void getRequest(APIResponseInterface apiResponseInterface, Call<MovieResult> call, Context context) {
        if (ConnectionUtils.checkConnectivity(context)) {
            call.enqueue(new Callback<MovieResult>() {
                @Override
                public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
                    apiResponseInterface.onResponse(response);
                }

                @Override
                public void onFailure(Call<MovieResult> call, Throwable t) {
                    apiResponseInterface.onError(t.getMessage());
                }
            });
        } else {
            apiResponseInterface.onError(ConstantUtils.CONNECTION_ERROR);
        }
    }

}
