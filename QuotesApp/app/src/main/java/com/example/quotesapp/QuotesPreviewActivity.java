package com.example.quotesapp;

import static com.example.quotesapp.Utils.PermUtils.takePermission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.quotesapp.Adapters.SliderAdapter;
import com.example.quotesapp.Utils.DownloadFile;
import com.example.quotesapp.Utils.PermUtils;
import com.example.quotesapp.databinding.ActivityQuotesPreviewBinding;

import java.io.IOException;

public class QuotesPreviewActivity extends AppCompatActivity implements SliderAdapter.ItemClickListener {

    ActivityQuotesPreviewBinding binding;
    SliderAdapter adapter;

    int iconId = 0;
    String url = "";
    ImageView wallpaperImg;
    Dialog dialog;
    WallpaperManager wallpaperManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityQuotesPreviewBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        dialog = new Dialog(this);
        binding.backArrowImg.setOnClickListener(v -> finish());
        wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

        Intent intent = getIntent();
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        adapter = new SliderAdapter(intent.getStringArrayListExtra("urlList"), this, binding.parentLayout, this);
        binding.wallpaperSliderViewPager.setAdapter(adapter);
        binding.wallpaperSliderViewPager.setCurrentItem(getIntent().getIntExtra("position", 0), false);
    }

    @Override
    public void onItemClicked(ImageView item, ImageView wallpaperImg, String url) {
        iconId = item.getId();
        this.url = url;
        this.wallpaperImg = wallpaperImg;
        switch (item.getId()) {
            case R.id.icDownloadWallpaper:
                if (!PermUtils.isPermissionGranted(QuotesPreviewActivity.this)) {
                    new AlertDialog.Builder(this)
                            .setTitle(getResources().getString(R.string.permission_needed))
                            .setMessage(getResources().getString(R.string.app_requires_some_permissions))
                            .setPositiveButton(getResources().getString(R.string.allow), (dialogInterface, i) -> takePermission(QuotesPreviewActivity.this))
                            .setNegativeButton(getResources().getString(R.string.deny), (dialogInterface, i) -> {
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert).show();
                } else {
                    DownloadFile downloadFile = new DownloadFile(QuotesPreviewActivity.this, false);
                    downloadFile.execute(url);
                }
                break;
            case R.id.icShareWallpaper:
                if (!PermUtils.isPermissionGranted(QuotesPreviewActivity.this)) {
                    new AlertDialog.Builder(this)
                            .setTitle(getResources().getString(R.string.permission_needed))
                            .setMessage(getResources().getString(R.string.app_requires_some_permissions))
                            .setPositiveButton(getResources().getString(R.string.allow), (dialogInterface, i) -> takePermission(QuotesPreviewActivity.this))
                            .setNegativeButton(getResources().getString(R.string.deny), (dialogInterface, i) -> {
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert).show();
                } else {
                    shareImage(wallpaperImg);
                }

                break;
        }
    }

    private void shareImage(ImageView imageView) {
        Drawable mDrawable = imageView.getDrawable();
        Bitmap mBitmap = ((BitmapDrawable) mDrawable).getBitmap();
        String path = MediaStore.Images.Media.insertImage(getContentResolver(), mBitmap, "Image Description", null);
        Uri uri = Uri.parse(path);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/jpeg");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(intent, getResources().getString(R.string.share)));
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        try {
            return super.dispatchTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                if (iconId == R.id.icDownloadWallpaper)
                    new DownloadFile(QuotesPreviewActivity.this, false).execute(url);
                else if (iconId == R.id.icShareWallpaper)
                    shareImage(wallpaperImg);
            } else {
                Toast.makeText(this, getResources().getString(R.string.permission_denied), Toast.LENGTH_SHORT).show();
            }
        }
    }

}