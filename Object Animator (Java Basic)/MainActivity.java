package com.example.flipcardanimationsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button animateButton,animateButtonX;
    View redView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animateButton = findViewById(R.id.animateButton);
        redView = findViewById(R.id.redView);
        animateButtonX = findViewById(R.id.animateXBtn);
        animateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animate();
            }
        });
        animateButtonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateX();
            }
        });
    }


    public void animate(){
        ObjectAnimator ty = ObjectAnimator.ofFloat(redView,
                View.TRANSLATION_Y,
                redView.getTranslationY(),
                redView.getTranslationY() + 100f);

        ty.setDuration(500);
        ty.setInterpolator(new LinearInterpolator());
        ty.start();
    }


    public void animateX(){
        ObjectAnimator ty = ObjectAnimator.ofFloat(redView,
                View.TRANSLATION_X,
                redView.getTranslationX(),
                redView.getTranslationX() + 100f);

        ty.setDuration(500);
        ty.setInterpolator(new LinearInterpolator());
        ty.start();
    }

}