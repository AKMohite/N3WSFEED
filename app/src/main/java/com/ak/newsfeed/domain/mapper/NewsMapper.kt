package com.ak.newsfeed.domain.mapper

import com.ak.newsfeed.data.local.entity.NewsArticleEntity
import com.ak.newsfeed.data.remote.dto.ArticleDTO
import com.ak.newsfeed.domain.model.NewsArticle

class NewsMapper {
    fun mapEntityToDomain(article: NewsArticleEntity) =
        NewsArticle(
            title = article.title,
            url = article.url,
            author = article.author,
            newsImage = article.imgUrl,
            content = article.content
        )

    fun mapDTOToEntity(article: ArticleDTO) =
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