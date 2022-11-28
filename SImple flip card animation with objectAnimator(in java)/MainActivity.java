package com.example.flipcardanimationsample;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView redView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        redView = (TextView) findViewById(R.id.redView);
        redView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator anime_1 = ObjectAnimator.ofFloat(redView,
                        "scaleX", // scaleY can be used for vertical instead of X
                        1f,0f);

                ObjectAnimator anime_2 = ObjectAnimator.ofFloat(redView,
                        "scaleX", // scaleY can be used for vertical instead of X
                        0f,1f);

                anime_1.setInterpolator(new DecelerateInterpolator());
                anime_2.setInterpolator(new DecelerateInterpolator());

                anime_1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        if (redView.getText().toString() == "Front"){
                            redView.setText("Back");
                        }
                        else{
                            redView.setText("Front");
                        }
                        // If-else statement is added by me

                        anime_2.start();
                    }
                });
                anime_1.start();

//                Below code is for infinite execution of code
//                anime_2.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        super.onAnimationEnd(animation);
//                        redView.setText("Front");
//                        anime_1.start();
//                    }
//                });
//                anime_2.start();
            }
        });

    }
}



