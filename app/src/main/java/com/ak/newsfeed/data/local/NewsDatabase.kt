package com.ak.newsfeed.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ak.newsfeed.data.local.entity.NewsArticleEntity

@Database(
    entities = [NewsArticleEntity::class],
    version = 1
)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun newsDAO(): NewsDAO
}