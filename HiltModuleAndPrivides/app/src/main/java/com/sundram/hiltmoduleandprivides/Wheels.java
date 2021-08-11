package com.sundram.hiltmoduleandprivides;

public class Wheels {

    //we don't own this class so we can not annotate it

    private Rims rims;
    private Tires tires;

    public Wheels(Rims rims, Tires tires) {
        this.rims = rims;
        this.tires = tires;
    }
}
