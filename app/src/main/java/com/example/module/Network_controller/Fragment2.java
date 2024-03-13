package com.example.module.Network_controller;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;


import com.example.module.Module1_viewmodel;
import com.example.module.R;
import com.example.module.databinding.FragmentTwoBinding;


public class Fragment2 extends Fragment {

    View view;
    FragmentTwoBinding fragmentTwoBinding;
    Module1_viewmodel module1Viewmodel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentTwoBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_two,container,false);
        view = fragmentTwoBinding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        module1Viewmodel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(Module1_viewmodel.class);

        fragmentTwoBinding.fragment2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                module1Viewmodel.setData_string_fragments(fragmentTwoBinding.fragment2Text.getText().toString());
            }
        });
    }
}
