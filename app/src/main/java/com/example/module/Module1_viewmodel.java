package com.example.module;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.module.Module1_repo.Module1_repoistory;
import com.example.module.Network_controller.Posts;

import java.util.ArrayList;
import java.util.List;

public class Module1_viewmodel extends AndroidViewModel {

    public Module1_repoistory module1Repo;
    public List<Posts> postsList = new ArrayList<>();
    public Module1_viewmodel(@NonNull Application application) {
        super(application);

        module1Repo = new Module1_repoistory(application);
    }

    public void  get_data(){

        postsList = module1Repo.getposts_from_server();

    }
}
