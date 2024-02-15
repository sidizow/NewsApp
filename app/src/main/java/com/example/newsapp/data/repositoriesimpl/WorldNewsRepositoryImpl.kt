package com.example.newsapp.data.repositoriesimpl

import com.example.newsapp.data.datasources.worldnews.WorldNewsSource
import com.example.newsapp.domain.entities.NewsEntity
import com.example.newsapp.domain.world.repositories.WorldNewsRepository
import com.example.newsapp.utils.toNewsEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorldNewsRepositoryImpl @Inject constructor(
    private val worldNewsSource: WorldNewsSource,
) : WorldNewsRepository {

    override suspend fun getWorldNews(): List<NewsEntity> {
        val listArticle = worldNewsSource.getWorldNews().articles

        return listArticle.filter {
            it.title != null && it.description != null && it.imageUrl != null && it.publishedAt != null
        }.map { it.toNewsEntity() }
    }


}