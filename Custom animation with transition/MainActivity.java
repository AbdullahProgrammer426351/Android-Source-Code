package com.example.flipcardanimationsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    Scene firstScene;
    Scene secondScene;
    ViewGroup rootView;
    Transition transitionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = (ViewGroup) findViewById(R.id.rootActivity);
        firstScene = Scene.getSceneForLayout(rootView,R.layout.first_scene,this);
        secondScene = Scene.getSceneForLayout(rootView,R.layout.second_scene,this);
        firstScene.enter();

        transitionManager = TransitionInflater.from(this).inflateTransition(R.transition.transitions);

    }

    public void onImageClickEvent(View v){
        TransitionManager.go(secondScene,transitionManager);
    }
}



