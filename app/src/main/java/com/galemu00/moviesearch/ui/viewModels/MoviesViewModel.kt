package com.galemu00.moviesearch.ui.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galemu00.moviesearch.Util.Resource
import com.galemu00.moviesearch.data.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.Query
import javax.inject.Inject
import com.galemu00.moviesearch.data.model.Result as ResultMovies

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: MoviesRepository) : ViewModel() {

    // searchAction bar status
    val searchAppBarOpenState: MutableState<Boolean> = mutableStateOf(false)
    val searchText: MutableState<String> = mutableStateOf("")
    private val _searchedMovies = mutableStateOf<Resource<List<ResultMovies>>>(Resource.Idel())
    val searchMovies: MutableState<Resource<List<ResultMovies>>>
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

    private fun handelMoviesSearch(result: Response<List<ResultMovies>>): Resource<List<ResultMovies>> {
        if (result.isSuccessful) {
            result.body()?.let { results ->
                return Resource.Success(results)
            }
        }

        return Resource.Error(result.message())
    }

}