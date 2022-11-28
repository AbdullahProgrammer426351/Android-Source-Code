package com.example.fancyprog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fancyprog.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private int progr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        updateProgressBar();
        binding.buttonIncr.setOnClickListener(v -> {
            if (progr <= 90) {
                progr += 10;
                updateProgressBar();
            }
        });

        binding.buttonDecr.setOnClickListener(v->{
            if (progr >= 10) {
                progr -= 10;
                updateProgressBar();
            }
        });
    }

    private void updateProgressBar() {
        binding.progressBar.setProgress(progr);
        binding.textViewProgress.setText(progr + "%");
    }
}