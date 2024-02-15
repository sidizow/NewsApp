package com.example.newsapp.data.datasources.search

import com.example.newsapp.data.datasources.entities.NewsResponseSourceEntity

interface SearchNewsSource {

    suspend fun getSearchNews(query: String): NewsResponseSourceEntity

}