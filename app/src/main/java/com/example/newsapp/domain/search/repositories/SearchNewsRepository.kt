package com.example.newsapp.domain.search.repositories

import com.example.newsapp.domain.entities.NewsEntity

interface SearchNewsRepository {

    suspend fun getSearchNews(query: String): List<NewsEntity>

}