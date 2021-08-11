package com.sundram.fragmentdatapassing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStateManagerControl;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sundram.fragmentdatapassing.databinding.FragmentFormBinding;

public class FormFragment extends Fragment {

    FragmentFormBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFormBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        binding.submitDataBtn.setOnClickListener(view ->
        {
              try {
                  if (validateView()){
                      Bundle bundle = new Bundle();
                      bundle.putString("name",binding.nameEt.getText().toString().trim());
                      bundle.putString("email",binding.emailEt.getText().toString().trim());
                      bundle.putString("mobile",binding.mobileNumberEt.getText().toString().trim());
                      //set Blank to view
                      setBlankToView();
                      //use to jump between the fragment
                      Navigation.findNavController(view).navigate(R.id.showDataFragment,bundle);
                  }else{
                      Toast.makeText(getContext(), "Please fill the details..", Toast.LENGTH_SHORT).show();
                  }
              }catch (Exception e){
                  e.printStackTrace();
              }

        });
        return rootView;
    }

    private boolean validateView() {
        if (TextUtils.isEmpty(binding.emailEt.getText().toString().trim())){
            return false;
        }
        if (TextUtils.isEmpty(binding.nameEt.getText().toString().trim())){
            return false;
        }
        if (TextUtils.isEmpty(binding.mobileNumberEt.getText().toString().trim())){
            return false;
        }

        return true;
    }

    private void setBlankToView(){
        binding.mobileNumberEt.setText("");
        binding.nameEt.setText("");
        binding.emailEt.setText("");
    }

}