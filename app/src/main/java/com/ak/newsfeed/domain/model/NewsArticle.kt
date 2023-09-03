package com.ak.newsfeed.domain.model

import android.util.Log
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class NewsArticle(
    val title: String,
    val author: String,
    val newsImage: String,
    val content: String?,
    val url: String,
    val publishedAt: String,
    val source: String
) {
    fun getReadableDate(): String {
        return try {
            val parsedDate = LocalDateTime.parse(this.publishedAt.replace("Z", ""), DateTimeFormatter.ISO_DATE_TIME)
            parsedDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm a"))
        } catch (e: Throwable) {
            Log.e(NewsArticle::class.java.simpleName, e.stackTraceToString())
            ""
        }
    }
}
