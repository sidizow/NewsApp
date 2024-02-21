package com.example.newsapp.data.repositoriesimpl

import com.example.newsapp.data.datasources.world.WorldNewsSource
import com.example.newsapp.domain.entities.DataItem
import com.example.newsapp.domain.world.repositories.WorldNewsRepository
import com.example.newsapp.utils.notNull
import com.example.newsapp.utils.toNewsEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorldNewsRepositoryImpl @Inject constructor(
    private val worldNewsSource: WorldNewsSource,
) : WorldNewsRepository {

    override suspend fun getWorldNews(): List<DataItem> {
        val listArticle = worldNewsSource.getWorldNews().articles
        val listData: MutableList<DataItem> = listArticle.filter { it.notNull() }
            .map { it.toNewsEntity() }
            .toMutableList()
        for (i in 5..listData.size step 5) {
            listData.add(i, DataItem.Header())
        }
        return listData
    }


}