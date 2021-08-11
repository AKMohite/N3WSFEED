package com.ak.newsfeed.domain.model

data class NewsArticle(
    val title: String,
    val author: String,
    val newsImage: String,
    val content: String?,
    val url: String
)