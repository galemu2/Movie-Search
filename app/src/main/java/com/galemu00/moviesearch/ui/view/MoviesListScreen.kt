package com.galemu00.moviesearch.ui.view

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.galemu00.moviesearch.ui.viewModels.MoviesViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MoviesListScreen(viewModel: MoviesViewModel) {

    var searchBarState by remember { viewModel.searchAppBarOpenState }

    LaunchedEffect(key1 = viewModel.searchAppBarOpenState, block = {
        searchBarState = viewModel.searchAppBarOpenState.value
    })

    var result by remember { viewModel.movieSearchResult }
    LaunchedEffect(key1 = viewModel.movieSearchResult, block = {
        result = viewModel.movieSearchResult.value
    })

    Scaffold(
        modifier = Modifier,
        topBar = {
            MoviesAppBar(
                searchActionBarOpened = searchBarState,
                viewModel = viewModel
            )

        },
    ) {
        MoviesResult(result)
    }
}