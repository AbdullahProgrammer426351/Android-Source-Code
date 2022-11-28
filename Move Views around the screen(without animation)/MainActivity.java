package com.example.flipcardanimationsample;


import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    float xDown=0, yDown=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // the user just put his finger down on the imageView
                switch (motionEvent.getActionMasked()){
                    case MotionEvent.ACTION_DOWN:
                        xDown = motionEvent.getX();
                        yDown = motionEvent.getY();
                        break;
                // the user moved his finger

                    case MotionEvent.ACTION_MOVE:
                        float xMoved, yMoved;
                        xMoved = motionEvent.getX();
                        yMoved = motionEvent.getY();

                        // calculate how the user moved his finger
                        float distanceX = xMoved - xDown;
                        float distanceY = yMoved - yDown;


                        // now move the view to that position
                        imageView.setX(imageView.getX()+distanceX);
                        imageView.setY(imageView.getY()+distanceY);
                        break;
                }
                return true;
            }
        });

    }

}