package com.example.jetpackpractice;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;


public class Adapters {
    Context context;
    ImageView imageView;

    public Adapters(Context context, ImageView imageView) {
        this.context = context;
        this.imageView = imageView;
    }
    @BindingAdapter("customMethodeToLoadUrl")
    void loadImageFromUrl(String url){
        Glide.with(context).load(url).into(imageView);
    }

}
