package com.example.newsapp.data.datasources.search

import com.example.newsapp.data.datasources.entities.NewsResponseSourceEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchNewsApi {

    @GET("everything")
    suspend fun getSearchNews(
        @Query("q") q: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String,
    ): NewsResponseSourceEntity

}