package com.sundram.navbasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
         navController = navHostFragment.getNavController();

    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.login_frag_btn:
//                navController.navigate(FirstFragmentDirections.actionFirstFragmentToLoginFragment());
//                break;
//            case R.id.blank_frag_btn:
//                        navController.navigate(FirstFragmentDirections.actionFirstFragmentToBlankFragment());
//                break;
//        }
//    }
}