package com.sundram.magenative.apiservices;

import com.sundram.magenative.models.home.HomePage;
import com.sundram.magenative.models.home.Parameters;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface HomeApiService {

    @POST("getNewHomepage")
    Observable<HomePage> getHomePageData(@Body Parameters parameters);
}
