package com.example.newsapp.domain.science.usecases

import com.example.newsapp.domain.entities.DataItem
import com.example.newsapp.domain.science.repositories.ScienceNewsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetScienceNewsUseCase @Inject constructor(
    private val scienceNewsRepository: ScienceNewsRepository
) {

    suspend fun getScienceNews(): List<DataItem>{
        return scienceNewsRepository.getScienceNews()
    }

}