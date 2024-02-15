package com.example.newsapp.data.datasources.sience

import com.example.newsapp.data.datasources.entities.NewsResponseSourceEntity

interface ScienceNewsSource {

    suspend fun getScienceNews(): NewsResponseSourceEntity

}