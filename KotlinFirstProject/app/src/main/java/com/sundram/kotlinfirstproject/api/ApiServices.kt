package com.sundram.kotlinfirstproject.api

import com.sundram.kotlinfirstproject.datamodel.SearchResponse
import com.sundram.kotlinfirstproject.util.ConstantUtils.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiServices {

    @POST()
    suspend fun searchMovie(
        @Query("apikey") apikey: String,
        @Query("s") movieName: String,
        @Query("type") type: String,
        @Query("page") page: Int
    ): SearchResponse

    companion object {
        fun create(): ApiServices {
            val logger = HttpLoggingInterceptor()
            logger.level = Level.BASIC
            val client = OkHttpClient.Builder().addInterceptor(logger).build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiServices::class.java)
        }
    }
}