package com.sundram.magenative.models.home;

import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("deal_image_name")
    private String dealImageName;

    @SerializedName("link_to")
    private String linkTo;

    @SerializedName("product_id")
    private String productId;

    public String getDealImageName() {
        return dealImageName;
    }

    public void setDealImageName(String dealImageName) {
        this.dealImageName = dealImageName;
    }

    public String getLinkTo() {
        return linkTo;
    }

    public void setLinkTo(String linkTo) {
        this.linkTo = linkTo;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

}
