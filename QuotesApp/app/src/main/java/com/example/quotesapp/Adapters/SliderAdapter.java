package com.example.quotesapp.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.quotesapp.R;

import java.util.ArrayList;

public class SliderAdapter extends PagerAdapter {
    ArrayList<String> list;
    Context context;
    ViewGroup viewGroup;
    ItemClickListener itemClickListener;

    public SliderAdapter(ArrayList<String> list, Context context, ViewGroup viewGroup, ItemClickListener itemClickListener) {
        this.list = list;
        this.context = context;
        this.viewGroup = viewGroup;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        LayoutInflater layoutInflater = LayoutInflater.from(container.getContext()).inflate(R.layout.wallpaper_slider_item, container, false);
        View view = inflater.inflate(R.layout.wallpaper_slider_item, container, false);
        container.addView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.imgWallpaper);
        ProgressBar progressBar = view.findViewById(R.id.progressBar);
        Glide.with(context).load(list.get(position))
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(imageView);
        ImageView downloadImg, shareImg;
        downloadImg = view.findViewById(R.id.icDownloadWallpaper);
        shareImg = view.findViewById(R.id.icShareWallpaper);
        downloadImg.setOnClickListener(v -> itemClickListener.onItemClicked(downloadImg, imageView, list.get(position)));
        shareImg.setOnClickListener(v -> itemClickListener.onItemClicked(shareImg, imageView, list.get(position)));

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ViewGroup) object);

    }

    public interface ItemClickListener {
        void onItemClicked(ImageView item, ImageView wallpaperImg, String url);
    }
}
