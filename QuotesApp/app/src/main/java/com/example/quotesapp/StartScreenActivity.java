package com.example.quotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.quotesapp.databinding.ActivityStartScreenBinding;

public class StartScreenActivity extends AppCompatActivity {

    ActivityStartScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.MainTheme);
        binding = ActivityStartScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.startBtn.setOnClickListener(v->{
            startActivity(new Intent(StartScreenActivity.this, MainActivity.class));
            finish();
        });
    }
}