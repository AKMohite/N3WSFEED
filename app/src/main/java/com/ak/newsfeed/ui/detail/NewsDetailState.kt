package com.ak.newsfeed.ui.detail

import com.ak.newsfeed.domain.model.NewsArticle

data class NewsDetailState (
    val isLoading: Boolean = false,
    val article: NewsArticle? = null,
    val error: String? = null
)
