package com.sundram.bottomnavexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sundram.bottomnavexample.databinding.FragmentProductBinding;
import com.sundram.bottomnavexample.databinding.FragmentProfileBinding;
import com.sundram.bottomnavexample.viewmodel.ProfileViewModel;

public class ProfileFragment extends Fragment {

    private ProfileViewModel viewModel;
    private FragmentProfileBinding binding;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //step 1st get view model object with help of ViewModelProviders
        viewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        //now step 2nd get binding object and inflate the view
        binding=FragmentProfileBinding.inflate(inflater,container,false);

        //now set 3rd create object of view class with help of binding.getRoot()
        View root = binding.getRoot();

        //now get view with help of binding object

        textView = binding.textProfile;

        //set the observer using view model so that when data changes it will reflect ot view with help of LiveData

        viewModel.getText().observe(getViewLifecycleOwner(), s -> textView.setText(s));

        return root;
    }
}