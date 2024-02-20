package com.example.newsapp.data.repositoriesimpl

import com.example.newsapp.data.datasources.world.WorldNewsSource
import com.example.newsapp.domain.entities.NewsEntity
import com.example.newsapp.domain.world.repositories.WorldNewsRepository
import com.example.newsapp.utils.toNewsEntity
import com.example.newsapp.utils.validate
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorldNewsRepositoryImpl @Inject constructor(
    private val worldNewsSource: WorldNewsSource,
) : WorldNewsRepository {

    override suspend fun getWorldNews(): List<NewsEntity> {
        val listArticle = worldNewsSource.getWorldNews().articles

        return listArticle.filter { it.validate() }
            .map { it.toNewsEntity() }
    }


}