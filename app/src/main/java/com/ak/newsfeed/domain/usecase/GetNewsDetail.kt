package com.ak.newsfeed.domain.usecase

import com.ak.newsfeed.data.local.source.ILocalDataSource
import com.ak.newsfeed.domain.mapper.NewsMapper
import com.ak.newsfeed.domain.model.NewsArticle
import javax.inject.Inject

class GetNewsDetail @Inject constructor(
    private val localDataSource: ILocalDataSource,
    private val mapper: NewsMapper
) {
    suspend operator fun invoke(id: String): NewsArticle {
        val article = localDataSource.getArticleDetail(id) ?: throw IllegalArgumentException("No article found with id $id")
        return mapper.mapEntityToDomain(article)
    }
}