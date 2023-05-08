package com.ak.newsfeed.data.local.entity

import android.util.Log
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Entity(tableName = "article")
data class NewsArticleEntity(
    @PrimaryKey(autoGenerate = false)
    val url: String,
    val author: String,
    val content: String?,
    val description: String,
    val publishedAt: String,
    val title: String,
    val imgUrl: String,
    val source: String
) {
    fun getReadableDate(): String {
        return try {
            val parsedDate = LocalDateTime.parse(this.publishedAt.replace("Z", ""), DateTimeFormatter.ISO_DATE_TIME)
            parsedDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))
        } catch (e: Throwable) {
            Log.e(NewsArticleEntity::class.java.simpleName, e.stackTraceToString())
            ""
        }
    }
}
