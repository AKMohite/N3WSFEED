package com.ak.newsfeed.data.remote.source

import com.ak.newsfeed.data.remote.dto.TopHeadlineDTO

interface IRemoteDataSource {
    suspend fun getTopHeadlines(country: String, pageSize: Int): TopHeadlineDTO
}