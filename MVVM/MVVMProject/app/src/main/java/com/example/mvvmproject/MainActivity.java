package com.example.mvvmproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvmproject.Adapter.ActorAdapter;
import com.example.mvvmproject.Model.Actor;
import com.example.mvvmproject.Network.Api;
import com.example.mvvmproject.Repository.ActorRepository;
import com.example.mvvmproject.ViewModel.ActorViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ActorViewModel actorViewModel;
    private RecyclerView recyclerView;
    private static final String URL_DATA = "http://www.codingwithjks.tech/data.php/";
    private List<Actor> actorList;
    private ActorRepository actorRepository;
    private ActorAdapter actorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actorViewModel = new ViewModelProvider(this).get(ActorViewModel.class);
        setContentView(R.layout.activity_main);

        actorList = new ArrayList<>();
        actorAdapter = new ActorAdapter(this, actorList);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        actorRepository = new ActorRepository(getApplication());

        actorViewModel.getAllActor().observe(this, new Observer<List<Actor>>() {
            @Override
            public void onChanged(List<Actor> actors) {
                actorAdapter.getAllActors(actorList);
                recyclerView.setAdapter(actorAdapter);
                Toast.makeText(getApplicationContext(), "adapter set successfully", Toast.LENGTH_SHORT).show();
            }
        });
        networkRequest();
    }

    private void networkRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_DATA)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // the above code will convert json code into java code

        Api api = retrofit.create(Api.class);
        Call<List<Actor>> call = api.getAllActors();
        call.enqueue(new Callback<List<Actor>>() {
            @Override
            public void onResponse(Call<List<Actor>> call, Response<List<Actor>> response) {
                // the whole data is now present in (response named) variable
                if(response.isSuccessful()){
                    actorRepository.insert(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Actor>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}