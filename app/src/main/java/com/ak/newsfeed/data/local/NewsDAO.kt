package com.ak.newsfeed.data.local

import androidx.room.*
import com.ak.newsfeed.data.local.entity.NewsArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(articles: List<NewsArticleEntity>)

    @Query("SELECT * FROM article")
    suspend fun getArticles(): List<NewsArticleEntity>

    @Query("DELETE FROM article")
    suspend fun deleteArticles()
}