package com.sundram.bottomnavexample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductViewModel extends ViewModel {
    private MutableLiveData<String> text;

    public ProductViewModel(){
        text = new MutableLiveData<>();
        text.setValue("This is product fragment");
    }

    public LiveData<String> getText(){
        return text;
    }
}
