package com.ak.newsfeed.data.remote.source

import com.ak.newsfeed.BuildConfig
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class MockInterceptor: Interceptor {

    private val responseCode = 200
    private val topHeadlineResponse by lazy {
        getResourceAsText("top-headlines/1.json")
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        if (BuildConfig.DEBUG) {
            val uri = chain.request().url.toUri().toString()
            val responseString = when {
                uri.contains("top-headlines") -> topHeadlineResponse
                else -> ""
            }

            return chain.proceed(chain.request())
                .newBuilder()
                .code(responseCode)
                .protocol(Protocol.HTTP_2)
                .message(responseString)
                .body(
                    responseString.toByteArray()
                        .toResponseBody("application/json".toMediaTypeOrNull())
                )
                .addHeader("content-type", "application/json")
                .build()
        } else {
            //just to be on safe side.
            throw IllegalAccessError("MockInterceptor is only meant for Testing Purposes and " +
                    "bound to be used only with DEBUG mode")
        }
    }

    private fun getResourceAsText(path: String): String {
        return object {}.javaClass.classLoader?.getResource(path)?.readText() ?: ""
    }

}