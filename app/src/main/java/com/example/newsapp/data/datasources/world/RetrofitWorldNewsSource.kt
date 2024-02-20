package com.example.newsapp.data.datasources.world

import com.example.newsapp.data.datasources.base.BaseRetrofitSource
import com.example.newsapp.data.datasources.base.Const
import com.example.newsapp.data.datasources.base.RetrofitConfig
import com.example.newsapp.data.datasources.entities.NewsResponseSourceEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitWorldNewsSource @Inject constructor(
    config: RetrofitConfig,
    private val worldNewsApi: WorldNewsApi
) : BaseRetrofitSource(config), WorldNewsSource {

    override suspend fun getWorldNews(): NewsResponseSourceEntity = wrapRetrofitExceptions {
            worldNewsApi.getWorldNews(
                country = Const.US
            )
        }
}