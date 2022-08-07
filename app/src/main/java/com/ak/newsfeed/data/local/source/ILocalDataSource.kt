package com.ak.newsfeed.data.local.source

import com.ak.newsfeed.data.local.entity.NewsArticleEntity

interface ILocalDataSource {
    suspend fun addArticles(article: List<NewsArticleEntity>)
    suspend fun getArticles() : List<NewsArticleEntity>
    suspend fun deleteArticles()
}