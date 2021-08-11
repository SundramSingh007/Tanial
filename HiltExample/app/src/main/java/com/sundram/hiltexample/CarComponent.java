package com.sundram.hiltexample;

/*
* component class is most necessary  class because this is the class where activity get objects
* which needed
* */

import dagger.Component;

/*
* Now dagger will give compile time implementation for this interface and create all necessary
*  code (for initialization)
* */

@Component
public interface CarComponent {
//this is line is use for constructor injection
//    Car getCar();

    //this line is use for member injection
    //And we can not pass Super class here like AppCompatActivity and Activity
    void inject(MainActivity mainActivity);
}
