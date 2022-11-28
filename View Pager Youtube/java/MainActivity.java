package com.example.viewpageryoutube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        int []images = {R.drawable.img1,R.drawable.img2,
                R.drawable.img3,R.drawable.img4};
        int []colors = {
                getResources().getColor(R.color.white),getResources().getColor(R.color.green),
                getResources().getColor(R.color.red),getResources().getColor(R.color.yellow)
        };
        viewPager.setAdapter(new MyAdpter(images,MainActivity.this,colors ));
    }
}