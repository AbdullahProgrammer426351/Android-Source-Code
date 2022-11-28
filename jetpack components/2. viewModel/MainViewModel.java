package com.example.bottomnavpractice;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    int count = 0;

    int increment(){
        count++;
        return count;
    }
}
