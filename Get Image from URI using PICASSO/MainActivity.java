package com.example.getimagefromurlusingpicasso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
        String url = "https://www.google.com/search?q=mountains+images&tbm=isch&source=iu&ictx=1&fir=1V4qNQg1qNZeiM%252Cm-RtkFK2iNctFM%252C_&vet=1&usg=AI4_-kSYwE2J3_dl1zt1tqa7hsTPRzYeuQ&sa=X&ved=2ahUKEwjPha7Lkt3yAhVVBGMBHRyKAVsQ9QF6BAgJEAE#imgrc=1V4qNQg1qNZeiM";

        Picasso.get().load(url).placeholder(R.drawable.ic_baseline_error_outline_24).into(imageView);
    }
}