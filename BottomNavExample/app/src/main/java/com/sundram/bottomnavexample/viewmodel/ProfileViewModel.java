package com.sundram.bottomnavexample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {
    private MutableLiveData<String> text;

    public ProfileViewModel(){
        text=new MutableLiveData<>();
        text.setValue("This is profile fragment");
    }

    public LiveData<String> getText(){
        return text;
    }
}
