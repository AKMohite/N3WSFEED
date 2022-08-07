package com.ak.newsfeed.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ak.newsfeed.data.NewsResource
import com.ak.newsfeed.data.repository.INewsRepository
import com.ak.newsfeed.domain.model.NewsArticle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: INewsRepository
): ViewModel() {

    private val _liveData = MutableLiveData<NewsResource<List<NewsArticle>>>()

    val liveData: LiveData<NewsResource<List<NewsArticle>>>
        get() = _liveData

    init {
        getTopHeadlines()
    }

    fun getTopHeadlines() {
        repo.getTopHeadlines("us", 100)
                .onEach { dataWrapper ->
                    _liveData.value = dataWrapper
                }.launchIn(viewModelScope)
    }
}