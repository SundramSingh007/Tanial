package com.sundram.magenative.models.home;

import com.google.gson.annotations.SerializedName;

public class Widget {

    @SerializedName("banner_image")
    private String bannerImage;

    @SerializedName("link_to")
    private String linkTo;

    @SerializedName("product_id")
    private String productId;

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
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
