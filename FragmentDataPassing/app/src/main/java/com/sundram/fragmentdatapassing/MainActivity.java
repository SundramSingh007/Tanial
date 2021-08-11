package com.sundram.fragmentdatapassing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.sundram.fragmentdatapassing.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    protected ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * The binding object is created immediately after inflating the layout
         * to ensure that the view hierarchy isn't modified before it binds to
         * the views with expressions within the layout.
         *
         * */
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        //in the AppBarConfiguration Builder class passing fragment id from nav_graph because here we have  multiple top
        //level destination because here I'm using bottom nav

        //TODO NOTE
        //make sure that nav graph fragment id and menu item id must be same

        //in DrawerLayout or side nav we have no need to pass the ids of each destination instead

        /*AppBarConfiguration appBarConfiguration =
        new AppBarConfiguration.Builder(navController.getGraph()).build();
        * */
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.mainFragment, R.id.formFragment, R.id.showDataFragment
        ).build();

        //this line defines that how to get the navController object
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        NavController navController = navHostFragment.getNavController();
        //now with the help of NavigationUI and AppBarConfiguration class setting up the toolbar so that when ever
        //fragment navigated title should be change
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }
}