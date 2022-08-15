package com.ak.newsfeed.data

sealed class NewsResource<out R> {
    data class Success<out T>(val data: T) : NewsResource<T>()
    object Loading: NewsResource<Nothing>()
    data class Error(val throwable: Throwable?) : NewsResource<Nothing>()
}
