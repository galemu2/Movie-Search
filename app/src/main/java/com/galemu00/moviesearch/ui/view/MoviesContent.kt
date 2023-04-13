package com.galemu00.moviesearch.ui.view

import androidx.compose.runtime.Composable
import com.galemu00.moviesearch.Util.Resource
import com.galemu00.moviesearch.data.model.Movies
import com.galemu00.moviesearch.ui.MovieItem
import com.galemu00.moviesearch.ui.MoviesList

@Composable
fun MoviesResult(
    result: Resource<Movies>
) {


    when (result) {
        is Resource.Idle -> {
            IdleContent()
        }
        is Resource.Loading -> {
            LoadingContent()
        }
        is Resource.Success -> {
            if (result.data?.results?.isEmpty() == true) {
                EmptyMovieList()
            } else {
                val movies = result.data
                // TODO show movies
                MoviesList(movies = result.data)
            }
        }
        is Resource.Error -> {
            ErrorContent()
        }
        else -> {
            ErrorContent()
        }
    }


}