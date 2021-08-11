package com.sundram.navgraph;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentC extends Fragment {
    private OnBackPressedCallback callback;

    public FragmentC() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view_frag_c = inflater.inflate(R.layout.fragment_specify_amount_details, container, false);
        NavController navController = Navigation.findNavController(getActivity(), R.id.fragment_container_view);
        // The callback can be enabled or disabled here or in handleOnBackPressed()
        // This callback will only be called when MyFragment is at least Started.
        callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                navController.popBackStack(R.id.mainFragment, true);
                navController.navigate(R.id.mainFragment);
                callback.setEnabled(false);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getActivity(), callback);
        
        return view_frag_c;
    }

}