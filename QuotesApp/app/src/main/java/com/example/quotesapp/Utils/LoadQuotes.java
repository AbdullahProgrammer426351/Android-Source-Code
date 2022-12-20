package com.example.quotesapp.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.ActionBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.quotesapp.Adapters.QuotesAdapter;
import com.example.quotesapp.Model.Quotes;
import com.example.quotesapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class LoadQuotes {
    int pageNumber;
    ProgressBar loadingPB;
    Activity activity;
    List<Quotes> quotesList;
    QuotesAdapter adapter;
    String TAG = "LOADING";
    String category;
    ActionBar actionBar;

    public LoadQuotes(int pageNumber, ProgressBar loadingPB, Activity activity, List<Quotes> wallpaperArrayList,
                      QuotesAdapter wallpaperRVAdapter, String category, ActionBar actionBar) {
        this.pageNumber = pageNumber;
        this.loadingPB = loadingPB;
        this.activity = activity;
        this.quotesList = wallpaperArrayList;
        this.adapter = wallpaperRVAdapter;
        this.category = category;
        this.actionBar = actionBar;
    }

    public int getQuotes() {
        if (pageNumber == 1)
            loadingPB.setVisibility(View.VISIBLE);
        StringRequest request = new StringRequest(Request.Method.GET, "https://quote-garden.herokuapp.com/api/v3/quotes?genre=" + category + "&page=" + pageNumber,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loadingPB.setVisibility(View.GONE);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                String quote = object.getString("quoteText");
                                String author = object.getString("quoteAuthor");
                                quotesList.add(new Quotes(quote, author));
                            }
                            adapter.notifyDataSetChanged();
                            pageNumber++;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d(TAG, e.getMessage());
                        }
                    }
                }, e -> {
            try {
                new AlertDialog.Builder(activity).setTitle(activity.getResources().getString(R.string.error))
                        .setMessage(activity.getResources().getString(R.string.failed_to_load_data))
                        .setPositiveButton(activity.getResources().getString(R.string.refresh), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                getQuotes();
                            }
                        }).show();
                if (e.getMessage() != null)
                    Log.d(TAG, e.getMessage());
            }catch (Exception exp){
                Log.d("DIALOG_ERR", exp.getMessage());
            }

        });

        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        requestQueue.add(request);
        return ++pageNumber;
    }
}
