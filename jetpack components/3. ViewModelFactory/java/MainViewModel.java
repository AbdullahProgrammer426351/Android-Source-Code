package com.example.bottomnavpractice;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    int count = 0;

    public MainViewModel(int initialValue) {
        this.count = initialValue;
    }
    // view model factory is used when we have to pass parameters to viewModel class functions

    int increment(){
        count++;
        return count;
    }
}
