package com.example.ch7q1_highestscoresaverapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView heading = findViewById(R.id.Heading);
        EditText inputScore = findViewById(R.id.scoreInput);
        Button save = findViewById(R.id.saveButton);
        Button resetBtn = findViewById(R.id.resetBtn);
        SharedPreferences getShared = getSharedPreferences("score",MODE_PRIVATE);
        SharedPreferences shrd = getSharedPreferences("score",MODE_PRIVATE);
        SharedPreferences.Editor editor = shrd.edit();
        editor.putInt("Highest Score",0);
        Integer storedVal = getShared.getInt("Highest Score",0 );


        if(storedVal!=0){
            heading.setText(storedVal.toString());
        }


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer scoreVal = Integer.parseInt(inputScore.getText().toString());

                Integer storedVal = getShared.getInt("Highest Score",0 );
                if(scoreVal!=0 && scoreVal>storedVal){
                    editor.putInt("Highest Score",scoreVal);
                    editor.apply();
                    heading.setText(scoreVal.toString());
                }
                else{
                    Toast.makeText(MainActivity.this, scoreVal.toString() + " is smaller than " + storedVal.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.apply();
                Integer storedVal = getShared.getInt("Highest Score",0 );
                heading.setText(storedVal.toString());
            }
        });
    }
}