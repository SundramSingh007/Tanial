package com.sundram.bottomnavexample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> text;

    public HomeViewModel() {
        text=new MutableLiveData<>();
        text.setValue("This is home fragment");
    }

    public LiveData<String> getText(){
        return text;
    }
}
