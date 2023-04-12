package com.galemu00.moviesearch.ui.view

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.galemu00.moviesearch.data.model.Movies

@Composable
fun MoviesResult(
    moviesList: List<Movies>
) {
/*
    var movies = remember {
        mutableListOf<List<ResultMovies>>()
    }
    LaunchedEffect(key1 = moviesList, block = {
        movies = mutableListOf(moviesList)
    })*/

    if (moviesList.isEmpty()) {
        // TODO show empty screen
    } else {

        Toast.makeText(LocalContext.current, "Total Movies: ${moviesList.size}", Toast.LENGTH_SHORT)
            .show()
//        moviesList.forEach { movieItem ->
//
//        }
    }
}