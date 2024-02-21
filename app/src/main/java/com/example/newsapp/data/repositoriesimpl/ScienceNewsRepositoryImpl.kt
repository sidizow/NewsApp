package com.example.newsapp.data.repositoriesimpl

import com.example.newsapp.data.datasources.sience.ScienceNewsSource
import com.example.newsapp.domain.entities.DataItem
import com.example.newsapp.domain.science.repositories.ScienceNewsRepository
import com.example.newsapp.utils.notNull
import com.example.newsapp.utils.toNewsEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScienceNewsRepositoryImpl @Inject constructor(
    private val scienceNewsSource: ScienceNewsSource,
) : ScienceNewsRepository {

    override suspend fun getScienceNews(): List<DataItem> {
        val listArticle = scienceNewsSource.getScienceNews().articles
        val listData: MutableList<DataItem> = listArticle.filter { it.notNull() }
            .map { it.toNewsEntity() }
            .toMutableList()
        for (i in 5..listData.size step 5) {
            listData.add(i, DataItem.Header())
        }
        return listData
    }
}