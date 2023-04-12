package com.galemu00.moviesearch.di

import com.galemu00.moviesearch.data.MoviesApi
import com.galemu00.moviesearch.data.MoviesApi.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModuel {

    @Provides
    @Singleton
    fun providesRetrofit():Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideMoviesApi(retrofit: Retrofit):MoviesApi =
        retrofit.create(MoviesApi::class.java)
}
