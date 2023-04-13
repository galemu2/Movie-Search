package com.galemu00.moviesearch.ui.viewModels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galemu00.moviesearch.Util.Resource
import com.galemu00.moviesearch.data.MoviesRepository
import com.galemu00.moviesearch.data.model.Movies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: MoviesRepository) : ViewModel() {

    // searchAction bar status
    val searchAppBarOpenState: MutableState<Boolean> = mutableStateOf(false)
    val searchText: MutableState<String> = mutableStateOf("")

    private val _searchedMovies = mutableStateOf<Resource<Movies>>(Resource.Idle())
    val movieSearchResult: MutableState<Resource<Movies>>
        get() = _searchedMovies

    fun searchMovies(query: String) {
        viewModelScope.launch(Dispatchers.Main) {
            _searchedMovies.value = Resource.Loading()
            try {
                val result = repository.searchMovies(query = query)

                _searchedMovies.value = handelMoviesSearch(result)
            } catch (e: Exception) {
                _searchedMovies.value = Resource.Error(e.message)
            }
        }

    }

    private fun handelMoviesSearch(result: Response<Movies>): Resource<Movies> {
        if (result.isSuccessful) {
            result.body()?.let { results ->
                // TODO delete
                Log.d(
                    "TAGGGG", ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> handelMoviesSearch: ${
                        results
                            .results.size
                    }"
                )
                return Resource.Success(results)
            }
            Log.d("TAGGGG", "handelMoviesSearch: >>>>>>>>>>> Failed")

        }
        Log.d("TAGGGG", "handelMoviesSearch: >>>>>>>>>>> Failed")
        return Resource.Error(result.message())
    }

}