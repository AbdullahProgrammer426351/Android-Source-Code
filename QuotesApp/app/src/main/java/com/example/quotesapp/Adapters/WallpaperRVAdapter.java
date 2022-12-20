package com.example.quotesapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.quotesapp.QuotesPreviewActivity;
import com.example.quotesapp.R;

import java.util.ArrayList;

public class WallpaperRVAdapter extends RecyclerView.Adapter<WallpaperRVAdapter.ViewHolder> {
    private ArrayList<String> wallpaperRVArrayList;
    private Context context;

    public WallpaperRVAdapter(ArrayList<String> wallpaperRVArrayList, Context context) {
        this.wallpaperRVArrayList = wallpaperRVArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.wallpaper_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context)
                .load(wallpaperRVArrayList.get(position))
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(holder.wallpaperIV);
        holder.itemView.setOnClickListener(v -> {
            Log.d("URL_IMG", wallpaperRVArrayList.get(position));
            Intent intent = new Intent(context, QuotesPreviewActivity.class);
            intent.putStringArrayListExtra("urlList", wallpaperRVArrayList);
            intent.putExtra("position", position);
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return wallpaperRVArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView wallpaperIV;
        private ProgressBar progressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            wallpaperIV = itemView.findViewById(R.id.idIVWallpaper);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }
}
