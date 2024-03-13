package com.example.module;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.module.databinding.ActivityMainBinding;
import com.example.module.Network_controller.Network_response;



public class MainActivity extends AppCompatActivity implements Network_response {

    public Network_response networkResponse;
    public Module1_viewmodel module1Viewmodel;
    public ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
                setContentView(activityMainBinding.getRoot());

                module1Viewmodel = ViewModelProvider.AndroidViewModelFactory
                        .getInstance(getApplication()).create(Module1_viewmodel.class);

                activityMainBinding.setLifecycleOwner(this);
        networkResponse = this;
    }

    @Override
    public void Network_response_interface(Boolean isconnected) {

        if(isconnected){


        }else {
            Toast.makeText(getApplicationContext(),"No internet",Toast.LENGTH_SHORT).show();
        }
    }
}