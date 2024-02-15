package com.example.newsapp.domain.world.repositories

import com.example.newsapp.domain.entities.NewsEntity

interface WorldNewsRepository {

    suspend fun getWorldNews(): List<NewsEntity>

}