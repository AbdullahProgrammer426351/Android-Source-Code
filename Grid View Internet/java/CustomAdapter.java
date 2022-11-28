package com.example.girdviewinternet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int logos[];
    String name[];
    LayoutInflater inflter;

    public CustomAdapter(Context context, int[] logos, String[] name) {
        this.context = context;
        this.logos = logos;
        this.name = name;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return logos.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_gridview, null); // inflate the layout
        ImageView icon = (ImageView) view.findViewById(R.id.icon); // get the reference of ImageView
        TextView nameView = (TextView) view.findViewById(R.id.textdata);
        icon.setImageResource(logos[i]); // set logo images
        nameView.setText(name[i]);
        return view;
    }
}
