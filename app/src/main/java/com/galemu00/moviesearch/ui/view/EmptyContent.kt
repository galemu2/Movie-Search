package com.galemu00.moviesearch.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.galemu00.moviesearch.R
import com.galemu00.moviesearch.ui.theme.emptyBackGroundColor

@Composable
fun EmptyMovieList() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = emptyBackGroundColor
    ) {
        val imageDayMode = painterResource(id = R.drawable.ic_outline_retry)
        Image(
            painter = imageDayMode,
            contentDescription = stringResource(id = R.string.empty_result)
        )

    }
}