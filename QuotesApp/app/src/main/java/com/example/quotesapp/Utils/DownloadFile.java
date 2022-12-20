package com.example.quotesapp.Utils;


import static com.example.quotesapp.Utils.Utils.WALLPAPER_DIRECTORY_NAME;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.example.quotesapp.R;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFile extends AsyncTask<String, Integer, Long> {
    Context context;
    ProgressDialog mProgressDialog;
    boolean setWallpaper;

    String savePath = "";


    public DownloadFile(Context context, boolean setWallpaper) {
        this.context = context;
        mProgressDialog = new ProgressDialog(context);
        this.setWallpaper = setWallpaper;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressDialog.setMessage(context.getResources().getString(R.string.downloading));
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.setMax(100);
        mProgressDialog.setCancelable(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.show();
    }

    @Override
    protected Long doInBackground(String... aurl) {
        int count;
        try {
            URL url = new URL((String) aurl[0]);
            URLConnection conexion = url.openConnection();
            conexion.connect();
            String targetFileName = "img" + System.currentTimeMillis() + ".jpg";//Change name and subname
            int lenghtOfFile = conexion.getContentLength();

//            String PATH = Environment.getExternalStorageDirectory().getAbsolutePath()
            String PATH = Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_DOWNLOADS + "/"
                    + WALLPAPER_DIRECTORY_NAME + "/";
            Log.d("LoadingError", "savePath : " + savePath);
            savePath = PATH + "/" + targetFileName;
            File folder = new File(PATH);
            Log.d("LoadingErrorPATH", PATH);
            boolean suc = false;
            if (!folder.exists()) {
                try {
                suc = folder.mkdirs();//If there is no folder it will be created.
                    Log.d("Downloading", "success");
                }catch (Exception e){
                    Log.d("DownloadingErrorE", e.getMessage());
                    Log.d("Downloading", "failed");
                }
            }
            InputStream input = new BufferedInputStream(url.openStream());


            OutputStream output = new FileOutputStream(savePath);
            byte data[] = new byte[1024];
            long total = 0;
            while ((count = input.read(data)) != -1) {
                total += count;
                publishProgress((int) (total * 100 / lenghtOfFile));
                output.write(data, 0, count);
            }
            output.flush();
            output.close();
            input.close();
            File file = new File(savePath);
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));
        } catch (Exception e) {
            mProgressDialog.dismiss();
            Log.d("DownloadingError", e.getMessage());
        }
        return null;
    }

    protected void onProgressUpdate(Integer... progress) {
        mProgressDialog.setProgress(progress[0]);
        if (mProgressDialog.getProgress() == mProgressDialog.getMax()) {
            mProgressDialog.dismiss();
            if (!setWallpaper)
                Toast.makeText(context, context.getResources().getString(R.string.file_downloaded), Toast.LENGTH_SHORT).show();
        }
    }

}
