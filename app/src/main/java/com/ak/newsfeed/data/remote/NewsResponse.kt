package com.ak.newsfeed.data.remote


import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)

data class Article(
//    extra key-values
    val id: Int,
    val bgColor: String,
    val viewType: Int = 0, // 0 = simple text news, 1 = image news, 2 video news
    val videoUrl: String,
    val isFav: Boolean = false,
//    extra key-values
    @SerializedName("author")
    val author: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("source")
    val source: Source,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String
)

data class Source(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)