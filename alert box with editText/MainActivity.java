package com.example.alertandsnackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText Input = findViewById(R.id.et_input);
        Button Show = findViewById(R.id.bt_show);

        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Text = Input.getText().toString();
                if (Text.isEmpty()){
                    alert("Please Enter Data !!!");
                }
                else{
                    alert(Text);
                }
            }
        });
    }
    private void alert(String message){
        AlertDialog dlg = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Message")
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create();
        dlg.show();
    }
}