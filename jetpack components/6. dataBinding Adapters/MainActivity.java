package com.example.jetpackpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.jetpackpractice.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Post postObj = new Post("Title", "Description",
                "data:image/jpeg;base64,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"

        );
        binding.setPost(postObj);


    }
}