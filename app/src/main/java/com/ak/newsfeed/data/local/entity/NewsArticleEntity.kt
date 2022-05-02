package com.ak.newsfeed.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class NewsArticleEntity(
    @PrimaryKey(autoGenerate = false)
    val url: String,
    val author: String,
    val content: String?,
    val description: String,
    val publishedAt: String,
    val title: String,
    val imgUrl: String
)