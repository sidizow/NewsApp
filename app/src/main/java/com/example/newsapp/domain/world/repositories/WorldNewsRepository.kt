package com.example.newsapp.domain.world.repositories

import com.example.newsapp.domain.entities.DataItem

interface WorldNewsRepository {

    suspend fun getWorldNews(): List<DataItem>

}