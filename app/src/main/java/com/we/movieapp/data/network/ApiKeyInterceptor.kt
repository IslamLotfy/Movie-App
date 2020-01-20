package com.we.movieapp.data.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created at Tito on 3/15/19
 *
 * An Interceptor class that making some automation by sending api_key to every api request by default.
 */

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", "fc47660226072874be57974ff797a0cd")
            .build()

        val requestBuilder = original.newBuilder().url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}