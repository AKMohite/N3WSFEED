package com.ak.newsfeed.data.remote

import com.ak.newsfeed.data.remote.dto.TopHeadlineDTO
import retrofit2.http.GET
import retrofit2.http.Query

// todo make internal but hilt is not allowing
interface NewsAPIService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("pageSize") pageSize: Int
    ): TopHeadlineDTO
}
