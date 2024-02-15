package com.example.newsapp.domain.science.repositories

import com.example.newsapp.domain.entities.NewsEntity

interface ScienceNewsRepository {

    suspend fun getScienceNews(): List<NewsEntity>

}