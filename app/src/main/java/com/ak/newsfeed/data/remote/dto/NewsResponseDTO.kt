package com.ak.newsfeed.data.remote.dto

data class NewsResponseDTO(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)

data class Article(
//    extra key-values
    val id: Int?,
    val bgColor: String?,
    val viewType: Int = 0, // 0 = simple text news, 1 = image news, 2 video news
    val videoUrl: String? = "",
    val isFav: Boolean = false,
    val authorImage: String?,
//    extra key-values
    val author: String? = "",
    val content: String? = "",
    val description: String? = "",
    val publishedAt: String? = "",
    val source: Source? = null,
    val title: String? = "",
    val url: String? = "",
    val urlToImage: String? = ""
)

data class Source(
    val id: String,
    val name: String
)