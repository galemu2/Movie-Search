package com.galemu00.moviesearch.Util

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Idle<T> : Resource<T>()
    class Loading<T> : Resource<T>()
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(message: String?) : Resource<T>(message = message)
}
