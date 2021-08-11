package com.sundram.hiltexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.lang.reflect.Constructor;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    /*
    In activity we can use construction injection because of instantiation
     * Dagger does not support injection into private fields
     * */
    @Inject
    Car car;

    //this is constructor injection example
    private Calculation calculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this line will init the car object
        CarComponent carComponent = DaggerCarComponent.create();
        //now with the help component object will get car object
        //this is define how to access filed/member injection
        carComponent.inject(MainActivity.this);
        car.drive();

        //this how we use constructor injection
        CalculationComponent calculationComponent = DaggerCalculationComponent.create();
        calculation = calculationComponent.getCal();
        calculation.squareArea();
    }
}