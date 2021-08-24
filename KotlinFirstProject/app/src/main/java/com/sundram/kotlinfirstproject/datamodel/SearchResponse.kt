package com.sundram.kotlinfirstproject.datamodel

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("Search") val search: List<Search>,
    @SerializedName("totalResults") val totalResults: String,
    @SerializedName("Response") val response: String
)