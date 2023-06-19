package com.techskillstests.rickandmortycharacterssearcher.core.di

import com.techskillstests.rickandmortycharacterssearcher.searcher.data.network.SearcherClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
        @Provides
        @Singleton
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit
                .Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        @Provides
        @Singleton
        fun provideHttpClient(): OkHttpClient {
            val interceptor= HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            return OkHttpClient.Builder().addInterceptor(interceptor).build()
        }
    @Provides
    fun provideSearcherClient (retrofit: Retrofit): SearcherClient = retrofit.create(SearcherClient::class.java)
}