package com.galemu00.moviesearch.ui.view

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.galemu00.moviesearch.ui.MoviesAppBar
import com.galemu00.moviesearch.ui.viewModels.MoviesViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesListScreen(viewModel: MoviesViewModel) {

    val moviesResult by viewModel.movieSearchResult
    LaunchedEffect(key1 = true, block = {

    })

    Scaffold(
        modifier = Modifier,
        topBar = {
            MoviesAppBar(
                searchActionBarOpened = false,
                viewModel = viewModel
            )

        },
    ) {}
}