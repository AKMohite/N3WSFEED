package com.ak.newsfeed.data.repository

import android.util.Log
import com.ak.newsfeed.data.remote.source.IRemoteDataSource
import com.ak.newsfeed.domain.model.NewsArticle
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val remoteDataSource: IRemoteDataSource
) : INewsRepository {
    override suspend fun getTopHeadlines(country: String, pageSize: Int): List<NewsArticle> {
        val newList = ArrayList<NewsArticle>()
        try {
            val remoteData = remoteDataSource.getTopHeadlines(country, pageSize)
            if (!remoteData.articles.isNullOrEmpty()) {
                remoteData.articles.forEach { article ->
                    newList.add(
                            NewsArticle(
                                    title = article.title,
                                    url = article.url
                            )
                    )
                }
            }
        } catch (e: Exception) {
            Log.d("NewsRepository", "getTopHeadlines: $e")
        }
        return newList //todo map articles
    }
}