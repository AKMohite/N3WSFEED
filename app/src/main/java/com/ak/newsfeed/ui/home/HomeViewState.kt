package com.ak.newsfeed.ui.home

import com.ak.newsfeed.domain.model.NewsArticle

data class HomeViewState(
    val isLoading: Boolean = false,
    val newsArticles: List<NewsArticle> = emptyList(),
    val error: String? = null
)