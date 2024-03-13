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
import com.example.module.databinding.FragmentOneBinding;

public class Fragment1 extends Fragment {

    View view;
    Module1_viewmodel module1Viewmodel;
    FragmentOneBinding fragmentOneBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentOneBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false);

        view = fragmentOneBinding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        module1Viewmodel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(Module1_viewmodel.class);
        fragmentOneBinding.fragment1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                module1Viewmodel.setData_string_fragments(fragmentOneBinding.fragment1Text.getText().toString());
            }
        });

    }
}
