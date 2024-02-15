package com.example.newsapp.di

import com.example.newsapp.data.repositoriesimpl.ScienceNewsRepositoryImpl
import com.example.newsapp.data.repositoriesimpl.SearchNewsRepositoryImpl
import com.example.newsapp.data.repositoriesimpl.WorldNewsRepositoryImpl
import com.example.newsapp.domain.science.repositories.ScienceNewsRepository
import com.example.newsapp.domain.search.repositories.SearchNewsRepository
import com.example.newsapp.domain.world.repositories.WorldNewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindWorldNewsRepository(
        worldNewsRepositoryImpl: WorldNewsRepositoryImpl
    ): WorldNewsRepository

    @Binds
    abstract fun bindScienceNewsRepository(
        scienceNewsRepositoryImpl: ScienceNewsRepositoryImpl
    ): ScienceNewsRepository

    @Binds
    abstract fun bindSearchNewsRepository(
        searchRepositoryImpl: SearchNewsRepositoryImpl
    ): SearchNewsRepository
}