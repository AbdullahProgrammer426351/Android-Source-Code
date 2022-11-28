package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView top_image,bottom_image;
    Animation top_anim,bottom_anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        top_image = findViewById(R.id.logo);
        bottom_image = findViewById(R.id.sub_logo);
        top_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.main_logo_animation);
        bottom_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sub_logo_animation);

        top_image.setAnimation(top_anim);
        bottom_image.setAnimation(bottom_anim);

//        To load page after some seconds
//        handler should be used from "android.os" source
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),dashboard.class));
                finish();
                // This line is used because if we don't use it, it will return back to splash screen
                // activity when back button will be pressed. Using this line, it will completely
                // finish previous activity
            }
        }, 5000);
    }
}