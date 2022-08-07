package com.ak.newsfeed.data.local.source

import com.ak.newsfeed.data.local.NewsDatabase
import com.ak.newsfeed.data.local.entity.NewsArticleEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val newsDB: NewsDatabase
) : ILocalDataSource {
    override suspend fun addArticles(article: List<NewsArticleEntity>) {
        newsDB.newsDAO().upsert(article)
    }

    override suspend fun getArticles(): List<NewsArticleEntity> {
//        todo return flow
        return newsDB.newsDAO().getArticles()
    }

    override suspend fun deleteArticles() {
        newsDB.newsDAO().deleteArticles()
    }
}