package com.example.jetpackpractice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
    @GET("posts")
    Call<List<Model>> getModels();
}
