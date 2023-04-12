package com.galemu00.moviesearch.data

import com.galemu00.moviesearch.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import com.galemu00.moviesearch.data.model.Result as ResultMovies

interface MoviesApi {

    //https://api.themoviedb.org/3/search/movie?api_key=<<api_key>>&language=en-US&page=1&include_adult=false
    companion object {
        private const val API_KEY = BuildConfig.API_KEY
        const val BASE_URL = "https://api.themoviedb.org/3/search/movie?api_key=$API_KEY/"
    }

    // searh moves and get list
    @GET
    suspend fun searchMovies(
        @Query("query")
        query: String
    ): Response<List<ResultMovies>>

    // load associated image
}