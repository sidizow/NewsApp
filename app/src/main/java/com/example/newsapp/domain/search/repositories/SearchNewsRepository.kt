package com.example.newsapp.domain.search.repositories

import com.example.newsapp.domain.entities.DataItem

interface SearchNewsRepository {

    suspend fun getSearchNews(query: String): List<DataItem>

}