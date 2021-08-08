package com.ak.newsfeed.data.repository

import com.ak.newsfeed.domain.model.NewsArticle

interface INewsRepository {
    suspend fun getTopHeadlines(country: String, pageSize: Int): List<NewsArticle>
}