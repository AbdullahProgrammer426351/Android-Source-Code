package com.example.viewpageryoutube;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MyAdpter extends PagerAdapter {
    int []images;
    int []colors;
    Context context;

    public MyAdpter(int[] images, Context context, int[] colors) {
        this.images = images;
        this.context = context;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.image_row,container,false);
        container.addView(v);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        ViewPager viewPager = (ViewPager) v.findViewById(R.id.viewPager);
        imageView.setImageResource(images[position]);
//        viewPager.setBackgroundColor(Color.parseColor(String.valueOf(colors[position])));
//        viewPager.setBackgroundColor(context.getResources().getColor(colors[position]));-->THis line gives crash
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ViewGroup)object);
    }
}
