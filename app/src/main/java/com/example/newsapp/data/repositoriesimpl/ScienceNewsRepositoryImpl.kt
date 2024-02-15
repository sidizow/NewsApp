package com.example.newsapp.data.repositoriesimpl

import com.example.newsapp.data.datasources.sience.ScienceNewsSource
import com.example.newsapp.domain.entities.NewsEntity
import com.example.newsapp.domain.science.repositories.ScienceNewsRepository
import com.example.newsapp.utils.toNewsEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScienceNewsRepositoryImpl @Inject constructor(
    private val scienceNewsSource: ScienceNewsSource,
) : ScienceNewsRepository {

    override suspend fun getScienceNews(): List<NewsEntity> {
        val listArticle = scienceNewsSource.getScienceNews().articles

        return listArticle.filter {
            it.title != null && it.description != null && it.imageUrl != null && it.publishedAt != null
        }.map { it.toNewsEntity() }
    }
}