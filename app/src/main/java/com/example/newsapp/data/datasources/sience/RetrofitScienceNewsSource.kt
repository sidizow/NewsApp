package com.example.newsapp.data.datasources.sience

import com.example.newsapp.data.datasources.base.ApiKey
import com.example.newsapp.data.datasources.base.BaseRetrofitSource
import com.example.newsapp.data.datasources.base.Const
import com.example.newsapp.data.datasources.base.RetrofitConfig
import com.example.newsapp.data.datasources.entities.NewsResponseSourceEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitScienceNewsSource @Inject constructor(
    config: RetrofitConfig,
) : BaseRetrofitSource(config), ScienceNewsSource {

    private val scienceNewsApi = retrofit.create(ScienceNewsApi::class.java)

    override suspend fun getScienceNews(): NewsResponseSourceEntity = wrapRetrofitExceptions{
        scienceNewsApi.getScienceNews(
            country = Const.US,
            category = Const.SCIENCE,
            apiKey = ApiKey.KEY
        )
    }
}