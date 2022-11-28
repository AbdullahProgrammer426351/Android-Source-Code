package com.example.gridviewyoutube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView grid;
    int icons[]=
            {
                    R.drawable.one,
                    R.drawable.two,
                    R.drawable.three,
                    R.drawable.four,
                    R.drawable.five,
                    R.drawable.six,
                    R.drawable.seven,
                    R.drawable.eight,
                    R.drawable.nine,
                    R.drawable.ten
            };
    String name[]=
            {
                    "Abdullah",
                    "Ali",
                    "Zunair",
                    "Hamza",
                    "Abdul Rehman",
                    "Rashid",
                    "Hassan",
                    "Haider",
                    "Mustafa",
                    "Hamid"
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = (GridView) findViewById(R.id.dataGrid);
        GridAdapter gridAdapter = new GridAdapter(name,icons,this);

//        grid.setAdapter(new gridAdapter(name,icons,this));
        grid.setAdapter(gridAdapter);
    }
}