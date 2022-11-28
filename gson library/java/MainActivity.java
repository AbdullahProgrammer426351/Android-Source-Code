package com.example.onlypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button btnReadJson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnReadJson = findViewById(R.id.btnReadJson);
        btnReadJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json_string = null;
                try {
                    InputStream inputStream = getAssets().open("abc.json");
                    int size = inputStream.available();
                    byte[] buffer = new byte[size];
                    inputStream.read(buffer);
                    inputStream.close();
                    json_string = new String(buffer, "UTF-8");
                    Toast.makeText(MainActivity.this, json_string, Toast.LENGTH_SHORT).show();
                    Gson gson = new Gson();
                    Post post = gson.fromJson(json_string, Post.class);

                    // how to access the converted objects
//                    post.father_details.fathername
                    Toast.makeText(MainActivity.this, post.father_details.fathername, Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}