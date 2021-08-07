package com.sundram.bottomnavexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.sundram.bottomnavexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * The binding object is created immediately after inflating the layout
         * to ensure that the view hierarchy isn't modified before it binds to
         * the views with expressions within the layout.
         *
         * */
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        //in the AppBarConfiguration Builder class passing fragment id from nav_graph because here we have  multiple top
        //level destination because here I'm using bottom nav

        //TODO NOTE
        //make sure that nav graph fragment id and menu item id must be same

        //in Drawer and side nav we have no need to pass the ids of each destination instead

        /*AppBarConfiguration appBarConfiguration =
        new AppBarConfiguration.Builder(navController.getGraph()).build();
        * */

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment,R.id.productFragment,R.id.profileFragment
        ).build();

        //this line defines that how to get the navController object
        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment_activity_main);

        //now with the help of NavigationUI and AppBarConfiguration class setting up the toolbar so that when ever
        //fragment navigated title should be change
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);

        //here with the NavigationUI and data binding setting up the nav controller
        NavigationUI.setupWithNavController(activityMainBinding.navView,navController);

    }
}