package com.sundram.magenative.models.home;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("product_id")
    private String productId;

    @SerializedName("product_name")
    private String productName;

    @SerializedName("type")
    private String type;

    @SerializedName("description")
    private String description;

    @SerializedName("Inwishlist")
    private String inwishlist;

    @SerializedName("wishlist_item_id")
    private String wishlistItemId;

    @SerializedName("stock_status")
    private Boolean stockStatus;

    @SerializedName("product_image")
    private String productImage;

    @SerializedName("review")
    private Double review;

    @SerializedName("special_price")
    private String specialPrice;

    @SerializedName("regular_price")
    private String regularPrice;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInwishlist() {
        return inwishlist;
    }

    public void setInwishlist(String inwishlist) {
        this.inwishlist = inwishlist;
    }

    public String getWishlistItemId() {
        return wishlistItemId;
    }

    public void setWishlistItemId(String wishlistItemId) {
        this.wishlistItemId = wishlistItemId;
    }

    public Boolean getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(Boolean stockStatus) {
        this.stockStatus = stockStatus;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Double getReview() {
        return review;
    }

    public void setReview(Double review) {
        this.review = review;
    }

    public String getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(String specialPrice) {
        this.specialPrice = specialPrice;
    }

    public String getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
    }
}
