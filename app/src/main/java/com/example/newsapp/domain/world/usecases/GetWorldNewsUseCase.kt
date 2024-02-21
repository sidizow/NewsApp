package com.example.newsapp.domain.world.usecases

import com.example.newsapp.domain.entities.DataItem
import com.example.newsapp.domain.world.repositories.WorldNewsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetWorldNewsUseCase @Inject constructor(
    private val worldNewsRepository: WorldNewsRepository
) {

    suspend fun getWorldNews(): List<DataItem>{
        return worldNewsRepository.getWorldNews()
    }

}