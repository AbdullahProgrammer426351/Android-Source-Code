package com.example.onlinevideoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView myVideoView = (VideoView) findViewById(R.id.videoView);
        Button button = findViewById(R.id.button);
        try
        {

            myVideoView.setVideoURI(Uri.parse("https://www.youtube.com/watch?v=wnHW6o8WMas"));
            myVideoView.setMediaController(new MediaController(this));
            myVideoView.requestFocus();
            myVideoView.start();
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "No Media found", Toast.LENGTH_LONG).show();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Pressed button", Toast.LENGTH_SHORT).show();
            }
        });






    }
}