package com.example.module.Network_controller;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Retrofit_service {

    @GET("posts")
    Call<List<Posts>> getdata();
}
