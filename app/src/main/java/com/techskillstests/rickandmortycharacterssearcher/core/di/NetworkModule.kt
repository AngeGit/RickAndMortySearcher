package com.techskillstests.rickandmortycharacterssearcher.core.di

import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

class NetworkModule {
        @Provides
        @Singleton
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit
                .Builder()
                .baseUrl("https://rickandmortyapi.com/api")
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
}