package com.galemu00.moviesearch.data

import com.galemu00.moviesearch.data.model.Movies
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepository @Inject constructor(private val moviesApi: MoviesApi) {

    suspend fun searchMovies(query: String): Response<Movies> {
        return moviesApi.searchMovies(query = query)
    }
}