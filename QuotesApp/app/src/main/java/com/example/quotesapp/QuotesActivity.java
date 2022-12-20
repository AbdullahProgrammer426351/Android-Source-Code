package com.example.quotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.quotesapp.Adapters.QuotesAdapter;
import com.example.quotesapp.Model.Quotes;
import com.example.quotesapp.Utils.NetworkChangeListener;
import com.example.quotesapp.databinding.ActivityQuotesBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuotesActivity extends AppCompatActivity {

    ActivityQuotesBinding binding;
    QuotesAdapter adapter;
    List<Quotes> quotesList = new ArrayList<>();
    NetworkChangeListener networkChangeListener = new NetworkChangeListener();
    public static final String TAG = "API_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        binding.backBtn.setOnClickListener(v -> finish());
        loadQuoteCategories();
        binding.quotesCategoryRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new QuotesAdapter(quotesList, this);
        binding.quotesCategoryRecycler.setAdapter(adapter);

    }

    public void loadQuoteCategories() {

        StringRequest request = new StringRequest(Request.Method.GET, "https://quote-garden.herokuapp.com/api/v3/genres",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        binding.progressBar.setVisibility(View.GONE);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                if (!jsonArray.get(i).toString().equals("dating")
                                        && !jsonArray.get(i).toString().equals("music")
                                        && !jsonArray.get(i).toString().equals("relationship")
                                        && !jsonArray.get(i).toString().equals("romantic")
                                )
                                    quotesList.add(new Quotes(jsonArray.get(i).toString(), null));
                            }
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                try {
                    new AlertDialog.Builder(QuotesActivity.this).setTitle(getResources().getString(R.string.error))
                            .setMessage(getResources().getString(R.string.failed_to_load_data))
                            .setPositiveButton(getResources().getString(R.string.refresh), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    loadQuoteCategories();
                                }
                            }).show();
                }catch (Exception exp){
                    Log.d("DIALOG_ERR", e.getMessage());
                }
                Log.d(TAG, "error ----> " + e.getMessage());

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);

    }

    @Override
    protected void onStart() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener, filter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeListener);
        super.onStop();
    }
}