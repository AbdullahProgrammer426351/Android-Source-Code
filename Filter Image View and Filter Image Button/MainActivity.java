package com.example.practicecomponents;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;

import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity {

    ImageFilterButton img_filter_btn;
    ImageFilterView img_filter_Img_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_filter_Img_view = findViewById(R.id.img_filter_Img_view);
        img_filter_btn = findViewById(R.id.img_filter_btn);
        img_filter_Img_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "filter Image View", Toast.LENGTH_SHORT).show();
            }
        });
        img_filter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Filter Image Button", Toast.LENGTH_SHORT).show();
            }
        });

    }
}


