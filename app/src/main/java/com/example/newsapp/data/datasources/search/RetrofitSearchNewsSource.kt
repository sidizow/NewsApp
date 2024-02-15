package com.example.newsapp.data.datasources.search

import com.example.newsapp.data.datasources.base.ApiKey
import com.example.newsapp.data.datasources.base.BaseRetrofitSource
import com.example.newsapp.data.datasources.base.Const
import com.example.newsapp.data.datasources.base.RetrofitConfig
import com.example.newsapp.data.datasources.entities.NewsResponseSourceEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitSearchNewsSource @Inject constructor(
    config: RetrofitConfig,
) : BaseRetrofitSource(config), SearchNewsSource {

    private val searchNewsApi = retrofit.create(SearchNewsApi::class.java)

    override suspend fun getSearchNews(query: String): NewsResponseSourceEntity = wrapRetrofitExceptions{
        searchNewsApi.getSearchNews(
            q = query,
            sortBy = Const.PUBLISHEDAT,
            apiKey = ApiKey.KEY
        )
    }
}