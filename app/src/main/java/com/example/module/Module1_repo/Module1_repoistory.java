package com.example.module.Module1_repo;

import android.content.Context;
import android.database.Cursor;

import com.example.module.MainActivity;
import com.example.module.Module1_database.Module_database;
import com.example.module.Network_controller.Posts;
import com.example.module.Network_controller.Retrofit_data;
import com.example.module.Network_controller.Retrofit_service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Handler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Module1_repoistory {


    public Module_database moduleDatabase;
    public Retrofit_service retrofitService;
    public List<Posts> list= new ArrayList<>();

    public Module1_repoistory(Context context) {
        if (moduleDatabase == null){
            moduleDatabase = new Module_database(context);
            moduleDatabase.Open();
        }

    }


    public List<Posts> getposts_from_server(){

        retrofitService = Retrofit_data.getRetrofit().create(Retrofit_service.class);

        Call<List<Posts>> postsCall = retrofitService.getdata();
        postsCall.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {

                list = response.body();
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });



        return list;


    }

    public List<String> getusers_from_local(){

        List<String> name = new ArrayList<>();
        try{
            Cursor cursor=null;

            cursor = moduleDatabase.getusers();
            while(cursor!=null && cursor.moveToNext()){

                name.add(cursor.getString(cursor.getColumnIndexOrThrow("user_name")));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return name;
    }




}
