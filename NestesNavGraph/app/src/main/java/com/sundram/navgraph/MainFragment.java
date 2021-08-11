package com.sundram.navgraph;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {

    private Button button_one,button_two,button_three;
    private View main_fragment_view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        main_fragment_view=inflater.inflate(R.layout.fragment_main, container, false);
        button_one=main_fragment_view.findViewById(R.id.view_transaction_btn);
        button_one.setOnClickListener(view ->{
            Navigation.findNavController(view).navigate(R.id.fragmentChoose);
        });
        return main_fragment_view;
    }

}