package com.example.flipcardanimationsample;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mListLayout;
    private ImageView mProfileImage;
    private TextView mNameText;
    private TextView mDescText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListLayout = findViewById(R.id.card_view);
        mProfileImage = findViewById(R.id.profile_image);
        mNameText = findViewById(R.id.title_text);
        mDescText = findViewById(R.id.slogan);


        mListLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharedIntent = new Intent(MainActivity.this, SharedActivity.class);
                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View,String>(mProfileImage, "imageTransition");
                pairs[1] = new Pair<View,String>(mNameText, "nameTransition");
                pairs[2] = new Pair<View,String>(mDescText, "sloganTransition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
//                        Pair.create(mProfileImage,"imageTransition"); ---> For single transition for one object
//                        but in case of multiple objects, we make arrays of Pair.

                startActivity(sharedIntent, options.toBundle());
            }
        });


    }

}



