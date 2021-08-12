package com.sundram.magenative.models.home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DealGroup {
    @SerializedName("title")
    private String title;

    @SerializedName("deal_duration")
    private Long dealDuration;

    @SerializedName("content")
    private List<Content> content = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDealDuration() {
        return dealDuration;
    }

    public void setDealDuration(Long dealDuration) {
        this.dealDuration = dealDuration;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }
}
