package com.example.newsapp.domain.search.usecases

import com.example.newsapp.domain.entities.DataItem
import com.example.newsapp.domain.search.repositories.SearchNewsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetSearchNewsUseCase @Inject constructor(
    private val searchNewsRepository: SearchNewsRepository
) {

    suspend fun getSearchNews(query: String): List<DataItem>{
        return searchNewsRepository.getSearchNews(query)
    }

}