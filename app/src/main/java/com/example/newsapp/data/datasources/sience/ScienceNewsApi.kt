package com.example.newsapp.data.datasources.sience

import com.example.newsapp.data.datasources.entities.NewsResponseSourceEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ScienceNewsApi {

    @GET("top-headlines")
    suspend fun getScienceNews(
        @Query("country") country: String,
        @Query("category") category: String
    ): NewsResponseSourceEntity

}