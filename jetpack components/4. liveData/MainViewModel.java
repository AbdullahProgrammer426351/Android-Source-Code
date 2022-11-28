package com.example.bottomnavpractice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    MutableLiveData<String> factsLiveDataObject = new MutableLiveData<>("This is a fact");

    void updateLiveData(){
        factsLiveDataObject.setValue("Another Fact");
    }
}
