package com.example.videoplayeryoutube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    ArrayList<VideoModel> videos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // This will clear the status bar also because we want full screen

        viewPager2 = (ViewPager2) findViewById(R.id.viewPager);
        videos = new ArrayList<>();

        VideoModel ob1 = new VideoModel("https://www.youtube.com/watch?v=ybgyq1E3i4E","Title1","This is simple 1 description which is coming from remote server");
        videos.add(ob1);

        VideoModel ob2 = new VideoModel("https://www.youtube.com/watch?v=Vy0mI4gG78g","Title2","This is simple 2 description which is coming from remote server");
        videos.add(ob2);


        VideoModel ob3 = new VideoModel("https://www.youtube.com/watch?v=4Xwj80GC2GI","Title3","This is simple 3 description which is coming from remote server");
        videos.add(ob3);


        VideoModel ob4 = new VideoModel("https://www.youtube.com/watch?v=Fnlef2IvYkM","Title4","This is simple 4 description which is coming from remote server");
        videos.add(ob4);

        viewPager2.setAdapter(new VideoAdapter(videos));

    }
}