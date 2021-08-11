package com.sundram.navgraph;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentB extends Fragment {

    private View view_specify_fragment;
    private Button jump_to_c_btn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view_specify_fragment = inflater.inflate(R.layout.fragment_specify_amount, container, false);
        view_specify_fragment.findViewById(R.id.jump_to_c_btn).setOnClickListener(view ->
        {
            Navigation.findNavController(view).navigate(R.id.fragmentSpecifyAmountDetails);
        });
        return view_specify_fragment;
    }
}