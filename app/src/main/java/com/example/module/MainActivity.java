package com.example.module;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.module.Module1_database.Module_database;
import com.example.module.Network_controller.Fragment1;
import com.example.module.Network_controller.Fragment2;
import com.example.module.Network_controller.Posts;
import com.example.module.databinding.ActivityMainBinding;
import com.example.module.Network_controller.Network_response;

import java.util.List;


public class MainActivity extends AppCompatActivity implements Network_response {

    public Network_response networkResponse;
    public Module_database moduleDatabase;
    public Module1_viewmodel module1Viewmodel;
    public ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        networkResponse = this;
        module1Viewmodel = ViewModelProvider.AndroidViewModelFactory
                .getInstance(getApplication()).create(Module1_viewmodel.class);

        activityMainBinding.setLifecycleOwner(this);

        activityMainBinding.fragmentSpace.setActivated(true);

        activityMainBinding.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //module1Viewmodel.get_data();
                Intent intent =new Intent(MainActivity.this, Second.class);
                intent.putExtra("name","chai");
                startActivity(intent);
            }
        });

        activityMainBinding.fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfragment(new Fragment1());
            }
        });

        activityMainBinding.fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfragment(new Fragment2());
            }
        });
        module1Viewmodel.liveData.observe(this, new Observer<List<Posts>>() {
            @Override
            public void onChanged(List<Posts> s) {

                for (Posts posts: s)
                {
                   // activityMainBinding.text.append(posts.getTitle());
                }

            }
        });

        module1Viewmodel.local_liveData.observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                for(String s: strings){
                    activityMainBinding.text.append(s);
                }

            }
        });

        module1Viewmodel.getData_string_fragments().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                activityMainBinding.text.setText(s);
            }
        });



    }

    @Override
    public void Network_response_interface(Boolean isconnected) {

        if (isconnected) {


        } else {
            Toast.makeText(getApplicationContext(), "No internet", Toast.LENGTH_SHORT).show();
        }
    }

    public void loadfragment(Fragment fragment){

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_space,fragment);
        fragmentTransaction.commit();
        fragmentTransaction.addToBackStack(null);
        getSupportFragmentManager().popBackStack();
    }
}