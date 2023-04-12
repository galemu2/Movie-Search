package com.galemu00.moviesearch.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.galemu00.moviesearch.Util.Resource
import com.galemu00.moviesearch.data.model.Movies
import com.galemu00.moviesearch.ui.theme.MovieSearchTheme
import com.galemu00.moviesearch.ui.viewModels.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MoviesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MovieSearchTheme {

                var movies by remember { mutableStateOf<Resource<Movies>>(Resource.Idle()) }
                var movieSize = 0
                var message = "null"

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LaunchedEffect(key1 = true, block = {
                        if (viewModel.movieSearchResult.value is Resource.Success) {
                            movieSize = viewModel.movieSearchResult.value.data?.results?.size ?: -1
                        } else {
                            message = viewModel.movieSearchResult.value.message.toString()
                        }
                    })
                    Column() {

                        Text(text = "Size: $movieSize", fontSize = 40.sp)
                        Text(text = "Message: $message", fontSize = 40.sp)

                    }
                    // MoviesListScreen(viewModel = viewModel)
                }
            }
        }
    }
}

