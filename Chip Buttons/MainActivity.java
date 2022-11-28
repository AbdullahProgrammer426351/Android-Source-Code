package com.example.practicecomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ChipGroup chipGroup;
    Button btnAddChip;
    int chipNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chipGroup = findViewById(R.id.chip_group);
        btnAddChip = findViewById(R.id.btn_add_chip);

        btnAddChip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chip chip = new Chip(MainActivity.this);
                chip.setText("chip" + chipNumber++);
                chip.setCheckable(true);
                chip.setCloseIcon(getDrawable(R.drawable.cancel_asset));
                chip.setCloseIconEnabled(true);

                chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked){
                            Toast.makeText(MainActivity.this, buttonView.getText().toString() + "is Selected", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, buttonView.getText().toString() + "is Unselected", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                chip.setOnCloseIconClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        chipGroup.removeView(v);
                    }
                });

                chipGroup.addView(chip,0);
            }
        });
    }
}