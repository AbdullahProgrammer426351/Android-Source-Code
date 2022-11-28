package com.example.databaselistview;

import static com.example.databaselistview.DataConstant.DB_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    MyDatabase myDatabase;
    DetailInfoDao detailInfoDao;
    List<MyDetailInfo> myDetailInfos;
    RecyclerView recyclerViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        myDatabase = Room.databaseBuilder(this, MyDatabase.class, DB_NAME)
                .allowMainThreadQueries().build();
        detailInfoDao = myDatabase.detailInfoDao();
        myDetailInfos = detailInfoDao.fetchAllData();
        recyclerViewData = findViewById(R.id.recyclerViewData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewData.setLayoutManager(linearLayoutManager);
        // Now we are making adapter
        if (myDetailInfos.size()>0){
        DataAdapter dataAdapter = new DataAdapter(DetailActivity.this, myDetailInfos);
        recyclerViewData.setAdapter(dataAdapter);
        }
    }
}