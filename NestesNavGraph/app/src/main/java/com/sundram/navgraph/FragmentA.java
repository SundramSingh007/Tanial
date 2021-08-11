package com.sundram.navgraph;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentA extends Fragment {

    private Button jump_to_specify_amount;
    private View view_fragment_choose;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view_fragment_choose=inflater.inflate(R.layout.fragment_choose, container, false);
        view_fragment_choose.findViewById(R.id.jump_to_specify_amount).setOnClickListener(view ->
                {
                    Navigation.findNavController(view).navigate(R.id.fragmentSpecifyAmount);
                }
        );
        return view_fragment_choose;
    }
}