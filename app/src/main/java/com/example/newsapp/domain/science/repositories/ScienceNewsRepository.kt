package com.example.newsapp.domain.science.repositories

import com.example.newsapp.domain.entities.DataItem

interface ScienceNewsRepository {

    suspend fun getScienceNews(): List<DataItem>

}