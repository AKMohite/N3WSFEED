package com.ak.newsfeed.data.repository

import com.ak.newsfeed.data.NewsResource
import com.ak.newsfeed.domain.model.NewsArticle
import kotlinx.coroutines.flow.Flow

interface INewsRepository {
    fun getTopHeadlines(country: String, pageSize: Int): Flow<NewsResource<List<NewsArticle>>>
}