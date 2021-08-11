package com.sundram.mvvm.activities.viewmodels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sundram.mvvm.model.MovieResult;
import com.sundram.mvvm.networ_utils.APICall;
import com.sundram.mvvm.networ_utils.APIResponseInterface;
import com.sundram.mvvm.repository.MovieRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Response;

@HiltViewModel
public class MainDataViewModel extends ViewModel {

    private MovieRepository repository;
    private APICall apiCall;
    private final MutableLiveData<Response<MovieResult>> movieMutableLiveData = new MutableLiveData<Response<MovieResult>>();
    public MutableLiveData<String> errorData = new MutableLiveData<>();

    //@ViewModelInject is deprecated now use @HiltViewModel

    @Inject
    public MainDataViewModel(MovieRepository repository, APICall apiCall) {
        this.repository = repository;
        this.apiCall = apiCall;
    }

    public MutableLiveData<Response<MovieResult>> getMovieResults(Context context, String keyWord){
       Call<MovieResult> movieResultCall= repository.getAllMoviesByKeyWord(keyWord);
       apiCall.getRequest(apiResponseInterface,movieResultCall,context);
       return movieMutableLiveData;
    }

    private final APIResponseInterface apiResponseInterface = new APIResponseInterface() {
        @Override
        public void onResponse(Response<MovieResult> response) {
            movieMutableLiveData.setValue(response);
        }

        @Override
        public void onError(String error) {
            errorData.setValue(error);
        }
    };
}
