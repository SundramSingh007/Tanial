package com.sundram.hiltexample;

import android.util.Log;

import javax.inject.Inject;

public class Calculation {

    private static final String TAG = "Calculation";

    private Width width;
    private Height height;

    @Inject
    public Calculation(Width width, Height height) {
        this.width = width;
        this.height = height;
    }

    public void squareArea() {
        Log.d(TAG, "squareArea: ");
    }
}
