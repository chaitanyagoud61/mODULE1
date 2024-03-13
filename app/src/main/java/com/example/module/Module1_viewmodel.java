package com.example.module;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.module.Module1_repo.Module1_repoistory;
import com.example.module.Network_controller.Posts;

import java.util.ArrayList;
import java.util.List;

public class Module1_viewmodel extends AndroidViewModel {

    public Module1_repoistory module1Repo;
    public List<Posts> postsList = new ArrayList<>();
    public MutableLiveData<List<Posts>> liveData = new MutableLiveData<>();
    private static final MutableLiveData<String> fragment_one_data = new MutableLiveData<String>();
    public MutableLiveData<List<String>> local_liveData = new MutableLiveData<>();


    public Module1_viewmodel(@NonNull Application application) {
        super(application);

        module1Repo = new Module1_repoistory(application);
    }


    public void setData_string_fragments(String s){
        fragment_one_data.setValue(s);
    }

    public LiveData<String> getData_string_fragments(){

        return fragment_one_data;
    }
    public void  get_data(){

        /*postsList = module1Repo.getposts_from_server();
        liveData.setValue(postsList);*/
        local_liveData.setValue(module1Repo.getusers_from_local());

    }

}
