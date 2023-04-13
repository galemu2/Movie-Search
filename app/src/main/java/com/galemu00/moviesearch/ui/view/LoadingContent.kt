package com.galemu00.moviesearch.ui.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.galemu00.moviesearch.ui.theme.emptyBackGroundColor

@Composable
fun LoadingContent() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = emptyBackGroundColor,

    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.scale(0.5f).fillMaxSize()
        , strokeWidth = 40.dp
        )
    }
}