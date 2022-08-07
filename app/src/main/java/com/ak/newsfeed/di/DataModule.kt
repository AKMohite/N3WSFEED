package com.ak.newsfeed.di

import android.content.Context
import androidx.room.Room
import com.ak.newsfeed.BuildConfig
import com.ak.newsfeed.data.local.NewsDatabase
import com.ak.newsfeed.data.remote.NewsAPIService
import com.ak.newsfeed.data.remote.source.MockInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://newsapi.org/v2/"
private const val API_KEY = "" // todo add apikey

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @LoggingInterceptor
    fun provideHttpLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
    }

    @Provides
    @MockingInterceptor
    fun provideMockInterceptor(): Interceptor = MockInterceptor()

    @Provides
    fun provideCallFactory(
        @LoggingInterceptor loggingInterceptor: Interceptor,
        @MockingInterceptor mockInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val url = original.url.newBuilder().addQueryParameter("apiKey", API_KEY).build()
                val request = original.newBuilder().url(url)
                chain.proceed(request.build())
            }
            .addInterceptor(loggingInterceptor)
            .addInterceptor(mockInterceptor)
            .build()
    }

    @Provides
    fun provideMoshiConverter(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }

    @Provides
    fun provideRetrofit(
        moshiConverterFactory: MoshiConverterFactory,
        callFactory: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .callFactory(callFactory)
        .addConverterFactory(moshiConverterFactory)
        .build()

    @Provides
    fun provideNewsAPI(retrofit: Retrofit): NewsAPIService {
        return retrofit.create(NewsAPIService::class.java)
    }

    @Provides
    fun provideNewsDB(
        @ApplicationContext context: Context
    ): NewsDatabase {
        return Room.databaseBuilder(context, NewsDatabase::class.java, "news.db")
            .build()
    }
}
