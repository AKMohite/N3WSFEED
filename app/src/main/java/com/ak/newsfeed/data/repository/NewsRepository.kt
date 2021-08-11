package com.ak.newsfeed.data.repository

import android.util.Log
import com.ak.newsfeed.data.NewsResource
import com.ak.newsfeed.data.remote.source.IRemoteDataSource
import com.ak.newsfeed.domain.model.NewsArticle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val remoteDataSource: IRemoteDataSource
) : INewsRepository {
    override fun getTopHeadlines(country: String, pageSize: Int): Flow<NewsResource<List<NewsArticle>>> {
        return flow {
            emit(NewsResource.Loading())
            var newList: List<NewsArticle> = arrayListOf()
            try {
                val remoteData = remoteDataSource.getTopHeadlines(country, pageSize)
                if (!remoteData.articles.isNullOrEmpty()) {
                    newList = remoteData.articles.filter { article ->
//                        todo need to handle UI
                        !article.urlToImage.isNullOrBlank()
                    }.map { article ->
                                NewsArticle(
                                        title = article.title,
                                        url = article.url,
                                        author = article.author ?: "",
                                        newsImage = article.urlToImage ?: "",
                                        content = article.content
                                )
                            }
                }
                emit(NewsResource.Success(newList)) //todo map articles
            } catch (e: Exception) {
                emit(NewsResource.Error(e))
                Log.d("NewsRepository", "getTopHeadlines: $e")
            }
        }
    }
}