package com.galemu00.moviesearch.data

import com.galemu00.moviesearch.BuildConfig
import com.galemu00.moviesearch.data.model.Movies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    // https://api.themoviedb.org/3/search/movie?api_key=<<api_key>>&query=star%20wars
    // base url : https://api.themoviedb.org/3/
    // Get : search/movie
    // https://image.tmdb.org/t/p/w600_and_h900_bestv2/hY6Ndq1O4JiEngZ7xIOtcLUCDTX.jpg
    companion object {
        private const val API_KEY = BuildConfig.API_KEY
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    // search moves and get list
    @GET("search/movie?api_key=${API_KEY}&")
    suspend fun searchMovies(
        @Query("query")
        query: String
    ): Response<Movies>

    // load associated image
}