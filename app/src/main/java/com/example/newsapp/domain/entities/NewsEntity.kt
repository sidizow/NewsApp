package com.example.newsapp.domain.entities

data class NewsEntity(
    val title: String,
    val content: String,
    val imageUrl: String,
    val publishedAt: String,
    val url: String
)
