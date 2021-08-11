package com.sundram.mvvm.utilities;

import com.sundram.mvvm.networ_utils.APICall;
import com.sundram.mvvm.repository.MovieRepository;
import com.sundram.mvvm.retrofit_service.APIServices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
* ApplicationComponent is Deprecated in Dagger Version 2.30
ApplicationComponent removed in Dagger Version 2.31
Alternatively SingletonComponent should be used instead of ApplicationComponent
* */

@Module
@InstallIn(SingletonComponent.class)
public class UtilsModulesClient {

    @Singleton
    @Provides
    static Retrofit getApiClient() {
        return new Retrofit.Builder().baseUrl(
                ConstantUtils.BASE_URL
        ).addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static APIServices provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(APIServices.class);
    }

    @Provides
    @Singleton
    static MovieRepository repository(APIServices apiService) {
        return new MovieRepository(apiService);
    }

    @Provides
    @Singleton
    static APICall apiCall(MovieRepository repository) {
        return new APICall(repository);
    }

}
