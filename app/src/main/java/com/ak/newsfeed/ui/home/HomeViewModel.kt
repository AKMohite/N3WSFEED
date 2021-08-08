package com.ak.newsfeed.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ak.newsfeed.data.repository.INewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: INewsRepository
): ViewModel() {

    fun getTopHeadlines() {
        viewModelScope.launch(Dispatchers.IO) {
            val listArticle = repo.getTopHeadlines("us", 100)
            Log.d("HomeViewModel", "getTopHeadlines: $listArticle")
        }
    }
}