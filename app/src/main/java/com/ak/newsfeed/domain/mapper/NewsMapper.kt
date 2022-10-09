package com.ak.newsfeed.domain.mapper

import com.ak.newsfeed.data.local.entity.NewsArticleEntity
import com.ak.newsfeed.data.remote.dto.ArticleDTO
import com.ak.newsfeed.domain.model.NewsArticle
import javax.inject.Inject

class NewsMapper @Inject constructor() {
    fun mapEntityToDomain(article: NewsArticleEntity) =
        NewsArticle(
            title = article.title,
            url = article.url,
            author = article.author,
            newsImage = article.imgUrl,
            content = article.content,
            publishedAt = article.publishedAt,
            source = article.source
        )

    fun mapDTOToEntity(article: ArticleDTO) =
        NewsArticleEntity(
            url = article.url,
            author = article.author ?: "NA",
            content = article.content,
            title = article.title,
            description = article.description ?: "NA",
            publishedAt = article.publishedAt,
            imgUrl = article.urlToImage ?: "no-image",
            source = article.source?.name ?: "NA"
        )
}