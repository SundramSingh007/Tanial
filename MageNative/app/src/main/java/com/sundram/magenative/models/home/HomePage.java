package com.sundram.magenative.models.home;

import com.google.gson.annotations.SerializedName;

public class HomePage {

    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
