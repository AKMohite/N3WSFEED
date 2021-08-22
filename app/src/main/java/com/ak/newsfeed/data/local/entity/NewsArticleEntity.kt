package com.ak.newsfeed.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class NewsArticleEntity(
    @PrimaryKey(autoGenerate = false)
    val url: String
)