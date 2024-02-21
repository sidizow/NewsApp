package com.example.newsapp.utils

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.newsapp.R
import com.example.newsapp.data.datasources.entities.Article
import com.example.newsapp.domain.entities.DataItem


fun Article.toNewsEntity(): DataItem.NewsEntity {
    return DataItem.NewsEntity(
        title = title!!,
        content = content!!,
        imageUrl = imageUrl!!,
        publishedAt = publishedAt!!.replace(regex = Regex("[a-z,A-Z]"), " "),
        url = url!!
    )
}

fun Article.notNull(): Boolean =
    title != null && content != null && imageUrl != null && publishedAt != null && url != null

fun Fragment.findTopNavController(): NavController {
    val topLevelHost =
        requireActivity().supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment?
    return topLevelHost?.navController ?: findNavController()
}