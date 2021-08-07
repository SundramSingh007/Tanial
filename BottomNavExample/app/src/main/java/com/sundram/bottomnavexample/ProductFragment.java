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
import com.sundram.bottomnavexample.viewmodel.ProductViewModel;
import com.sundram.bottomnavexample.viewmodel.ProfileViewModel;

public class ProductFragment extends Fragment {

    private FragmentProductBinding fragmentProductBinding;
    private ProductViewModel productViewModel;
    private TextView textView;
    public ProductFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //we access view model with help of viewModelProvider
        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        //now inflate the view
        fragmentProductBinding = FragmentProductBinding.inflate(inflater, container, false);
        View root = fragmentProductBinding.getRoot();

        textView=fragmentProductBinding.textProduct;

        productViewModel.getText().observe(getViewLifecycleOwner(), s -> textView.setText(s));

        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentProductBinding=null;
    }
}