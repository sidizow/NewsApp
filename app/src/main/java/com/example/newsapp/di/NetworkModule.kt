package com.example.newsapp.di

import com.example.newsapp.data.datasources.base.ApiKey
import com.example.newsapp.data.datasources.base.Const
import com.example.newsapp.data.datasources.search.SearchNewsApi
import com.example.newsapp.data.datasources.sience.ScienceNewsApi
import com.example.newsapp.data.datasources.world.WorldNewsApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(createLoggingInterceptor())
            .addInterceptor(createApiKeyInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideSearchNewsApi(retrofit: Retrofit): SearchNewsApi{
        return retrofit.create(SearchNewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideScienceNewsApi(retrofit: Retrofit): ScienceNewsApi{
        return retrofit.create(ScienceNewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWorldNewsApi(retrofit: Retrofit): WorldNewsApi {
        return retrofit.create(WorldNewsApi::class.java)
    }

    private fun createApiKeyInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", ApiKey.KEY).build()
            return@Interceptor chain.proceed(request = request)
            }
    }

    private fun createLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }




}