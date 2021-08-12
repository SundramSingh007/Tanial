package com.sundram.magenative.models.home;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.sundram.magenative.utils.ConstantUtils;

import java.util.List;

public class Data {

    @SerializedName("design")
    private List<Design> design = null;
    @SerializedName("status")
    
    private String status;


    public List<Design> getDesign() {
        return design;
    }

    public void setDesign(List<Design> design) {
        this.design = design;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
