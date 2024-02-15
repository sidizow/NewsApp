package com.example.newsapp.data.datasources.worldnews

import com.example.newsapp.data.datasources.base.ApiKey
import com.example.newsapp.data.datasources.base.BaseRetrofitSource
import com.example.newsapp.data.datasources.base.Const
import com.example.newsapp.data.datasources.base.RetrofitConfig
import com.example.newsapp.data.datasources.entities.NewsResponseSourceEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitWorldNewsSource @Inject constructor(
    config: RetrofitConfig,
) : BaseRetrofitSource(config), WorldNewsSource {

    private val worldNewsApi = retrofit.create(WorldNewsApi::class.java)

    override suspend fun getWorldNews(): NewsResponseSourceEntity = wrapRetrofitExceptions {
            worldNewsApi.getWorldNews(
                country = Const.US,
                apiKey = ApiKey.KEY
            )
        }
}