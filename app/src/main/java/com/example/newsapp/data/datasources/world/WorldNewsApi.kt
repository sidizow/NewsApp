package com.example.newsapp.data.datasources.world

import com.example.newsapp.data.datasources.entities.NewsResponseSourceEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface WorldNewsApi {

    @GET("top-headlines")
    suspend fun getWorldNews(
        @Query("country") country: String
    ): NewsResponseSourceEntity

}