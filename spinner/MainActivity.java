package com.example.alertandsnackbar;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spn;
    TextView tv;
    String country[] = {"Please select a country : ","Pakistan","USA","NewZealand","UAE","Bangladesh"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn = (Spinner) findViewById(R.id.spinner);
        tv = (TextView) findViewById(R.id.textView);

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item,country);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spn.setAdapter(adp);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                    tv.setText("");
                }
                else{
                    tv.setText("You have selected : " + country[i]);
                    tv.setTextColor(getResources().getColor(R.color.colorRed));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}