package com.sundram.fragmentdatapassing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sundram.fragmentdatapassing.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {
    FragmentMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        binding.jumpToAddDataFragment.setOnClickListener(view -> {
                    Navigation.findNavController(view).navigate(R.id.formFragment);
                }
        );

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}