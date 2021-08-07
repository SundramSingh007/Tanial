package com.sundram.bottomnavexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sundram.bottomnavexample.databinding.FragmentHomeBinding;
import com.sundram.bottomnavexample.viewmodel.HomeViewModel;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding fragmentHomeBinding;
    private TextView title;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        //inflating view using data binding
        fragmentHomeBinding=FragmentHomeBinding.inflate(inflater,container,false);
        View root = fragmentHomeBinding.getRoot();

        title=fragmentHomeBinding.textHome;

        homeViewModel.getText().observe(getViewLifecycleOwner(), s -> title.setText(s));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentHomeBinding=null;
    }
}