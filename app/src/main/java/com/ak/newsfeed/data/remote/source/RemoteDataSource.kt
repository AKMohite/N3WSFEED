package com.ak.newsfeed.data.remote.source

import com.ak.newsfeed.data.remote.NewsAPIService
import com.ak.newsfeed.data.remote.dto.TopHeadlineDTO
import javax.inject.Inject

// todo make internal
class RemoteDataSource @Inject constructor(
    private val api: NewsAPIService
) : IRemoteDataSource {
    override suspend fun getTopHeadlines(country: String, pageSize: Int): TopHeadlineDTO {
        return api.getTopHeadlines(country, pageSize)
    }
}
