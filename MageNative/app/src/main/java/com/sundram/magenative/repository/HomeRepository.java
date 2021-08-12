package com.sundram.magenative.repository;

import com.sundram.magenative.apiservices.HomeApiService;
import com.sundram.magenative.models.home.HomePage;
import com.sundram.magenative.models.home.Parameters;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class HomeRepository {

    private HomeApiService apiService;

    @Inject
    public HomeRepository(HomeApiService apiService) {
        this.apiService = apiService;
    }


    public Observable<HomePage> getHomePageData(Parameters parameters){
        return  apiService.getHomePageData(parameters);
    }
}
