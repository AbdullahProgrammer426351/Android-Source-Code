package com.example.listviewdevelopers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView;
        listView = (ListView) findViewById(R.id.list_view);
        ArrayList<String> arrayList;
        ArrayAdapter<String> adapter;
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        arrayList.add("Item 1");
        arrayList.add("Item 2");
        arrayList.add("Item 3");
        arrayList.add("Item 4");
        arrayList.add("Item 5");
        arrayList.add("Item 6");
        arrayList.add("Item 7");
        arrayList.add("Item 8");
        arrayList.add("Item 9");
        listView.setAdapter(adapter);
    }
}