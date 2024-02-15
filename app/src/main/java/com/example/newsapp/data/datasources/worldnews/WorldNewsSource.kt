package com.example.newsapp.data.datasources.worldnews

import com.example.newsapp.data.datasources.entities.NewsResponseSourceEntity

interface WorldNewsSource {

    suspend fun getWorldNews(): NewsResponseSourceEntity

}