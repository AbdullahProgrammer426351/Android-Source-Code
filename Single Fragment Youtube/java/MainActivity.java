package com.example.singlefragmentyoutube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager frm = getSupportFragmentManager();
                FragmentTransaction frt = frm.beginTransaction();
                frt.add(R.id.wrapper,new Fragment2());
                frt.addToBackStack(null);
                frt.commit();
            }
        });
    }
}