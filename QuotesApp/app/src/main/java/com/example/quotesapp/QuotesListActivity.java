package com.example.quotesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AbsListView;

import com.example.quotesapp.Adapters.QuotesAdapter;
import com.example.quotesapp.Model.Quotes;
import com.example.quotesapp.Utils.LoadQuotes;
import com.example.quotesapp.Utils.NetworkChangeListener;
import com.example.quotesapp.databinding.ActivityQuotesListBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuotesListActivity extends AppCompatActivity {

    ActivityQuotesListBinding binding;

    QuotesAdapter adapter;
    List<Quotes> quotesList = new ArrayList<>();

    // variables for infinite scrolling
    int pageNumber = 1;
    boolean isScrolling = false;
    int currentItems, totalItems, scrollOutItems;
    String category;
    NetworkChangeListener networkChangeListener = new NetworkChangeListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityQuotesListBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setTitle(getIntent().getStringExtra("Category"));
        getSupportActionBar().setTitle(getIntent().getStringExtra("Category"));

        category = getIntent().getStringExtra("Category");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.quotesCategoryRecycler.setLayoutManager(layoutManager);
        adapter = new QuotesAdapter(quotesList, this);
        binding.quotesCategoryRecycler.setAdapter(adapter);
        binding.quotesCategoryRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems = layoutManager.getChildCount();// returns number of current items in recycler view
                totalItems = layoutManager.getItemCount();// returns number of all items in recycler view
                scrollOutItems = layoutManager.findFirstVisibleItemPosition();

                if (isScrolling && (currentItems+scrollOutItems == totalItems)){
                    // if control enters in this function(i.e the above condition is true),
                    // it means that recycler view has reached to its end
                    isScrolling = false;
//                    getWallpapers();
                    pageNumber = new LoadQuotes(pageNumber, binding.loadingPB, QuotesListActivity.this, quotesList, adapter, category, getSupportActionBar())
                            .getQuotes();
//                    Log.d("PAGE_NUM", String.valueOf(pageNumber));
                }
            }
        });
        pageNumber = new LoadQuotes(pageNumber, binding.loadingPB, QuotesListActivity.this, quotesList, adapter, category, getSupportActionBar())
                .getQuotes();

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();// close activity when backButton pressed
        return super.onOptionsItemSelected(item);
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