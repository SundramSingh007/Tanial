package com.sundram.hiltexample;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private static final String TAG = "Car";
    private Engine engine;
    private Wheels wheels;

    /*
    * What if we use filed injection her
    *
    * Example:
    * @Inject Engine engine;
    * private Wheels wheels;
    *
    * @Inject
    * public Car(Wheels wheels){
    * this.wheels=wheels;
    * }
    *
    * @Inject
    * public void enableRemote(Remote remote){
    * remote.setListener(this)
    * }
    *
    *
    * in that flow will be
    * first dagger use Constructor
    * And then inject dependency to constructor
    * and the call method
    * */

    //this is called constructor injection
    @Inject
    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }
    
    public void drive(){
        Log.d(TAG, "drive: me...");
    }

    //method injection
    @Inject
    public void enableRemote(Remote remote){
        remote.setListener(this);
    }
}
