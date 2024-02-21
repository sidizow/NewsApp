package com.example.newsapp.data.repositoriesimpl

import com.example.newsapp.data.datasources.search.SearchNewsSource
import com.example.newsapp.domain.entities.DataItem
import com.example.newsapp.domain.search.repositories.SearchNewsRepository
import com.example.newsapp.utils.notNull
import com.example.newsapp.utils.toNewsEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchNewsRepositoryImpl @Inject constructor(
    private val searchNewsSource: SearchNewsSource,
) : SearchNewsRepository {

    override suspend fun getSearchNews(query: String): List<DataItem> {
        val listArticle = searchNewsSource.getSearchNews(query).articles
        val listData: MutableList<DataItem> = listArticle.filter { it.notNull() }
            .map { it.toNewsEntity() }
            .toMutableList()
        for (i in 5..listData.size step 5) {
            listData.add(i, DataItem.Header())
        }
        return listData
    }
}