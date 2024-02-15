package com.example.newsapp.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.data.datasources.entities.Article
import com.example.newsapp.domain.entities.NewsEntity

fun <T> MutableLiveData<T>.share(): LiveData<T> = this

fun Article.toNewsEntity(): NewsEntity {
    return NewsEntity(
        title = title!!,
        description = description!!,
        imageUrl = imageUrl!!,
        publishedAt = publishedAt!!.replace(regex = Regex("[a-z,A-Z]"), " ")
    )
}