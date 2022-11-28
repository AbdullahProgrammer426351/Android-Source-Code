package com.example.databaselistview;

import static com.example.databaselistview.DataConstant.DB_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDatabase myDatabase;
    private EditText etUserName,etFatherName,etPhone;
    Button btnSaveData,btnShowData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSaveData = findViewById(R.id.btnSaveData);
        btnShowData = findViewById(R.id.btnShowData);
        etUserName = findViewById(R.id.etUserName);
        etFatherName = findViewById(R.id.etFatherName);
        etPhone = findViewById(R.id.etPhone);
        myDatabase = Room.databaseBuilder(this, MyDatabase.class, DB_NAME)
                .allowMainThreadQueries().build();

        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUserName.getText().toString().length() == 0){
                    Toast.makeText(MainActivity.this, "Please Enter User Name", Toast.LENGTH_SHORT).show();
                }
                else if(etFatherName.getText().toString().length() == 0){
                    Toast.makeText(MainActivity.this, "Please Enter User Name", Toast.LENGTH_SHORT).show();
                }
                else if(etPhone.getText().toString().length() == 0){
                    Toast.makeText(MainActivity.this, "Please Enter User Name", Toast.LENGTH_SHORT).show();
                }
                else{
                    DetailInfoDao detailInfoDao = myDatabase.detailInfoDao();
                    MyDetailInfo myDetailInfo = new MyDetailInfo();
                    myDetailInfo.setName(etUserName.getText().toString());
                    myDetailInfo.setFatherName(etFatherName.getText().toString());
                    myDetailInfo.setPhoneNumber(etPhone.getText().toString());
                    // Save Data Now
                    detailInfoDao.insertUserDetail(myDetailInfo);
                    Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // show data
        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DetailActivity.class));
            }
        });




    }
}