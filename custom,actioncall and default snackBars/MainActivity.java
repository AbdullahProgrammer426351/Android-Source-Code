package com.example.alertandsnackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button customSnack,actionSnack,defaultSnack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customSnack = findViewById(R.id.customViewSnackBar);
        actionSnack = findViewById(R.id.actionCallSnackBar);
        defaultSnack = findViewById(R.id.defaultSnackBar);

        defaultSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view,"Abdullah",Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        actionSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view,"Message is Deleted",Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                // you can perform action or make a toast
                                Snackbar snackbar = Snackbar.make(view,"Message is restored",Snackbar.LENGTH_LONG);
                                snackbar.show();
                            }
                        });
                snackbar.show();
            }
        });


        customSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view,"This is custom",Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                // perform any action
                            }
                        });
                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.setTextColor(Color.RED);
                snackbar.show();
            }
        });

    }
}