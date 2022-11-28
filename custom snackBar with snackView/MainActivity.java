package com.example.alertandsnackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.constraint);

        findViewById(R.id.buttonSnackBar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(constraintLayout,"",Snackbar.LENGTH_LONG);

                View custom = getLayoutInflater().inflate(R.layout.snackbar_custom, null);

                snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
                Snackbar.SnackbarLayout  snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
                snackbarLayout.setPadding(0,0,0,0);

                (custom.findViewById(R.id.subscribe)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Thanks for Subscribing my channel", Toast.LENGTH_SHORT).show();
                        snackbar.dismiss();
                    }
                });
                snackbarLayout.addView(custom,0);
                snackbar.show();

            }
        });


    }
}