package com.example.newsapp.di

import com.example.newsapp.data.datasources.search.RetrofitSearchNewsSource
import com.example.newsapp.data.datasources.search.SearchNewsSource
import com.example.newsapp.data.datasources.sience.RetrofitScienceNewsSource
import com.example.newsapp.data.datasources.sience.ScienceNewsSource
import com.example.newsapp.data.datasources.worldnews.RetrofitWorldNewsSource
import com.example.newsapp.data.datasources.worldnews.WorldNewsSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SourceModule {

    @Binds
    abstract fun bindWorldNewsSource(
        retrofitWorldNewsSource: RetrofitWorldNewsSource
    ): WorldNewsSource

    @Binds
    abstract fun bindScienceNewsSource(
        retrofitScienceNewsSource: RetrofitScienceNewsSource
    ): ScienceNewsSource

    @Binds
    abstract fun bindSearchNewsSource(
        retrofitSearchNewsSource: RetrofitSearchNewsSource
    ): SearchNewsSource

}