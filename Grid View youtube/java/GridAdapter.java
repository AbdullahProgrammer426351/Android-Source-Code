package com.example.gridviewyoutube;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    private final String name[];

    public GridAdapter(String[] name, int[] images, Context context) {
        this.name = name;
        this.images = images;
        this.context = context;
    }

    private final int images[];
    Context context;
    @Override
    public int getCount() {
        return 0;
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.singleframe,null);
        ImageView img = (ImageView)view.findViewById(R.id.iconimage);
        TextView tv = (TextView)view.findViewById(R.id.textdata);

        img.setImageResource(images[position]);
        tv.setText(name[position]);
        return view;
    }
}
