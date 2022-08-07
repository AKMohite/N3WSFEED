package com.ak.newsfeed.domain.usecase

import android.util.Log
import com.ak.newsfeed.data.NewsResource
import com.ak.newsfeed.data.local.entity.NewsArticleEntity
import com.ak.newsfeed.data.local.source.ILocalDataSource
import com.ak.newsfeed.data.remote.source.IRemoteDataSource
import com.ak.newsfeed.domain.model.NewsArticle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RefreshNewsUseCase @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
    private val localDataSource: ILocalDataSource
) {

    operator fun invoke(
        params: RefreshParams
    ): Flow<NewsResource<List<NewsArticle>>> {
        return flow {
            emit(NewsResource.Loading())
            var newList: List<NewsArticle> = arrayListOf()
            try {
                val remoteData = remoteDataSource.getTopHeadlines(params.country, params.pageSize)
                if (!remoteData.articles.isNullOrEmpty()) {
                    val localEntity = remoteData.articles.filter { article ->
//                        todo need to handle UI
                        !article.urlToImage.isNullOrBlank()
                    }.map { article ->
                        NewsArticleEntity(
                            url = article.url,
                            author = article.author ?: "NA",
                            content = article.content,
                            title = article.title,
                            description = article.description ?: "NA",
                            publishedAt = article.publishedAt ?: "NA",
                            imgUrl = article.urlToImage!!
                        )
                    }
                    localDataSource.addArticles(localEntity)
                    newList = localDataSource.getArticles()
                        .map { article ->
                            NewsArticle(
                                title = article.title,
                                url = article.url,
                                author = article.author,
                                newsImage = article.imgUrl,
                                content = article.content
                            )
                        }
                }
                emit(NewsResource.Success(newList))
            } catch (e: Exception) {
                emit(NewsResource.Error(e))
                Log.d("NewsRepository", "getTopHeadlines: $e")
            }
        }
    }

    data class RefreshParams(
        val country: String = "us",
        val pageSize: Int = 100
    )
}