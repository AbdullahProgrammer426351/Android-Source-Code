package com.example.flipcardanimationsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.normalBtn).setOnClickListener(this);
        findViewById(R.id.fadeBtn).setOnClickListener(this);
        findViewById(R.id.slideBtn).setOnClickListener(this);

    }
    public void onClick(View view){
        startActivity(new Intent(this,SecondActivity.class));
        switch (view.getId()){
            case R.id.fadeBtn:
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.slideBtn:
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;

        }
    }
}



