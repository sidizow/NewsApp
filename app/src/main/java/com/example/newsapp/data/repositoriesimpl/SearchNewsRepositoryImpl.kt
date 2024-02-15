package com.example.newsapp.data.repositoriesimpl

import com.example.newsapp.data.datasources.search.SearchNewsSource
import com.example.newsapp.domain.entities.NewsEntity
import com.example.newsapp.domain.search.repositories.SearchNewsRepository
import com.example.newsapp.utils.toNewsEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchNewsRepositoryImpl @Inject constructor(
    private val searchNewsSource: SearchNewsSource,
) : SearchNewsRepository {

    override suspend fun getSearchNews(query: String): List<NewsEntity> {
        val listArticle = searchNewsSource.getSearchNews(query).articles
        return listArticle.filter {
            it.title != null && it.description != null && it.imageUrl != null && it.publishedAt != null
        }.map { it.toNewsEntity() }
    }
}