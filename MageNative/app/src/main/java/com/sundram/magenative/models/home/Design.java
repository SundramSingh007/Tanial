package com.sundram.magenative.models.home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Design {
    @SerializedName("link_type")
    private String linkType;

    @SerializedName("category_type")
    private String categoryType;

    @SerializedName("category_shape")
    private String categoryShape;

    @SerializedName("categories")
    private List<Category> categories = null;

    @SerializedName("title")
    private String title;

    @SerializedName("position")
    private String position;

    @SerializedName("widget")
    private List<Widget> widget = null;

    @SerializedName("banner_orientiation")
    private String bannerOrientiation;

    @SerializedName("type_of_banner")
    private String typeOfBanner;

    @SerializedName("banner")
    private Banner banner;

    @SerializedName("type_of_products")
    private String typeOfProducts;

    @SerializedName("category_id")
    private String categoryId;

    @SerializedName("category_name")
    private String categoryName;

    @SerializedName("products")
    private List<Product> products = null;

    @SerializedName("deal_group")
    private DealGroup dealGroup;

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getCategoryShape() {
        return categoryShape;
    }

    public void setCategoryShape(String categoryShape) {
        this.categoryShape = categoryShape;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Widget> getWidget() {
        return widget;
    }

    public void setWidget(List<Widget> widget) {
        this.widget = widget;
    }

    public String getBannerOrientiation() {
        return bannerOrientiation;
    }

    public void setBannerOrientiation(String bannerOrientiation) {
        this.bannerOrientiation = bannerOrientiation;
    }

    public String getTypeOfBanner() {
        return typeOfBanner;
    }

    public void setTypeOfBanner(String typeOfBanner) {
        this.typeOfBanner = typeOfBanner;
    }

    public Banner getBanner() {
        return banner;
    }

    public void setBanner(Banner banner) {
        this.banner = banner;
    }

    public String getTypeOfProducts() {
        return typeOfProducts;
    }

    public void setTypeOfProducts(String typeOfProducts) {
        this.typeOfProducts = typeOfProducts;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public DealGroup getDealGroup() {
        return dealGroup;
    }

    public void setDealGroup(DealGroup dealGroup) {
        this.dealGroup = dealGroup;
    }
}
