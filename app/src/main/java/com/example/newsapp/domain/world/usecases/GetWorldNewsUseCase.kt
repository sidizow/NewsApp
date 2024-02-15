package com.example.newsapp.domain.world.usecases

import com.example.newsapp.domain.entities.NewsEntity
import com.example.newsapp.domain.world.repositories.WorldNewsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetWorldNewsUseCase @Inject constructor(
    private val worldNewsRepository: WorldNewsRepository
) {

    suspend fun getWorldNews(): List<NewsEntity>{
        return worldNewsRepository.getWorldNews()
    }

}