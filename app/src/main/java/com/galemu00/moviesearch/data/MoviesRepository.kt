package com.galemu00.moviesearch.data

import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton
import com.galemu00.moviesearch.data.model.Result as ResultMovies

@Singleton
class MoviesRepository @Inject constructor(private val moviesApi: MoviesApi) {

    suspend fun searchMovies(query: String): Response<List<ResultMovies>> {
        return moviesApi.searchMovies(query = query)
    }
}