package com.example.newsapp.data.datasources.entities

import com.squareup.moshi.Json


data class NewsResponseSourceEntity(
    @field:Json(name = "status") val status: String,
    @field:Json(name = "totalResults") val totalResults: Int,
    @field:Json(name = "articles") val articles: List<Article>
)

data class Article(
    @field:Json(name = "author") val author: String?,
    @field:Json(name = "title")val title: String?,
    @field:Json(name = "description")val description: String?,
    @field:Json(name = "url")val url: String?,
    @field:Json(name = "urlToImage")val imageUrl: String?,
    @field:Json(name = "publishedAt")val publishedAt: String?,
    @field:Json(name = "content")val content: String?
)
