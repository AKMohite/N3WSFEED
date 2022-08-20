package com.ak.newsfeed.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopHeadlineDTO(
    val articles: List<ArticleDTO>?,
    val status: String?,
    val totalResults: Int?
)

@JsonClass(generateAdapter = true)
data class ArticleDTO(
    val author: String?,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: SourceDTO?,
    val title: String,
    val url: String,
    val urlToImage: String?
)

@JsonClass(generateAdapter = true)
data class SourceDTO(
    val id: String?,
    val name: String?
)
