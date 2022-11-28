package com.example.alertandsnackbar;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_win,btn_lose;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_win = findViewById(R.id.btnWin);
        btn_lose = findViewById(R.id.btn_lose);
        dialog = new Dialog(this);

        btn_win.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWinDialog();
            }
        });
        btn_lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoseDialog();
            }
        });

    }

    private void openLoseDialog() {
        dialog.setContentView(R.layout.lose_dialog_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        ImageView imageViewClose = dialog.findViewById(R.id.imageView_close);
        Button btnOk = dialog.findViewById(R.id.btnOk);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Dialog Close", Toast.LENGTH_SHORT).show();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Button Ok", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

    private void openWinDialog() {
        dialog.setContentView(R.layout.win_dialog_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        ImageView imageViewClose = dialog.findViewById(R.id.imageView_close);
        Button btnOk = dialog.findViewById(R.id.btnOk);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Dialog Close", Toast.LENGTH_SHORT).show();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Button Ok", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
}