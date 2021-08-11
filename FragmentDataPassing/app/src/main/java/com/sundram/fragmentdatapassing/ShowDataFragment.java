package com.sundram.fragmentdatapassing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sundram.fragmentdatapassing.databinding.FragmentShowDataBinding;


public class ShowDataFragment extends Fragment {

    private FragmentShowDataBinding binding;

    public ShowDataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentShowDataBinding.inflate(inflater,container,false);
        View rootView = binding.getRoot();
/*
* In your receiving destination’s code, use the getArguments() method to retrieve the Bundle and use its contents:
* */
        Bundle bundle = getArguments();
        binding.userName.setText(bundle.get("name").toString());
        binding.userEmail.setText(bundle.get("email").toString());
        binding.userMobile.setText(bundle.get("mobile").toString());


        return rootView;
    }
}