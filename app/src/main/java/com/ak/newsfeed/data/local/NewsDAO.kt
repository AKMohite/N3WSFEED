package com.ak.newsfeed.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ak.newsfeed.data.local.entity.NewsArticleEntity

@Dao
interface NewsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(articles: List<NewsArticleEntity>)

    @Query("SELECT * FROM article")
    suspend fun getArticles(): List<NewsArticleEntity>

    @Query("DELETE FROM article")
    suspend fun deleteArticles()
}
