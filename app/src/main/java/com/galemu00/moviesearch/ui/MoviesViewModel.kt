package com.galemu00.moviesearch.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MoviesViewModel:ViewModel(){

    // searchAction bar status
    val searchAppBarOpenState: MutableState<Boolean> = mutableStateOf(false)

}