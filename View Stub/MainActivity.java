package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    ViewStub viewStub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        viewStub = findViewById(R.id.stub_import);

//        When you want to load the layout specified by the ViewStub,
//        either set it visible by calling setVisibility(View.VISIBLE) or call inflate().
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewStub.getVisibility() != View.VISIBLE){
                    viewStub.setVisibility(View.INVISIBLE);
                }
                else{
                viewStub.setVisibility(View.VISIBLE);
                }
            }
        });

//        findViewById(R.id.stub_import).setVisibility(View.VISIBLE);
// or
//        View importPanel = ((ViewStub) findViewById(R.id.stub_import)).inflate();
    }
}