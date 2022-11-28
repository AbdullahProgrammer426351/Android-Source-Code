package com.example.bottomnavpractice;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class Observer implements LifecycleObserver {
    // it is class which is used to observe lifecycles of other components of android app
    // now we will make different functions about lifecycle. we can give any name to these functions

    // we will make onCreate method to observe onCreate method of activity and add annotation on it

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate(){
        Log.d("MainAbd", "Observer - On Create");
    }
}
