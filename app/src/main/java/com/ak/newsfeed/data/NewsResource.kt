package com.ak.newsfeed.data

sealed class NewsResource<T>(
        val data: T? = null,
        val error: Throwable? = null
) {
    class Success<T>(data: T) : NewsResource<T>(data)
    class Loading<T>(data: T? = null) : NewsResource<T>(data)
    class Error<T>(throwable: Throwable, data: T? = null) : NewsResource<T>(data, throwable)
}