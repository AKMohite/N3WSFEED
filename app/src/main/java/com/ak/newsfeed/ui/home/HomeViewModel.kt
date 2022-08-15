package com.ak.newsfeed.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ak.newsfeed.data.NewsResource
import com.ak.newsfeed.domain.model.NewsArticle
import com.ak.newsfeed.domain.usecase.RefreshNewsUseCase
import com.ak.newsfeed.domain.usecase.RefreshNewsUseCase.RefreshParams
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val refreshNewsUseCase: RefreshNewsUseCase
) : ViewModel() {

    var homeState = MutableStateFlow(HomeViewState())
        private set

    init {
        getTopHeadlines()
    }

    private fun getTopHeadlines() {
        viewModelScope.launch {
            refreshNewsUseCase(RefreshParams())
                .onEach { newsResource ->
                    when(newsResource) {
                        is NewsResource.Error -> {
                            homeState.value = homeState.value.copy(
                                isLoading = false,
                                error = newsResource.throwable?.message
                            )
                        }
                        is NewsResource.Loading -> {
                            homeState.value = homeState.value.copy(isLoading = true, error = null)
                        }
                        is NewsResource.Success -> {
                            homeState.value = homeState.value.copy(isLoading = false, error = null, newsArticles = newsResource.data)
                        }
                    }
                }
        }
    }
}

data class HomeViewState(
    val isLoading: Boolean = false,
    val newsArticles: List<NewsArticle> = emptyList(),
    val error: String? = null
)
