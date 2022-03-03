package com.arbisoft.dogbreedsearch.di.module

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class ApiHttpModule {
    fun getHTTPClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)

        httpClient.addInterceptor { chain ->
            val request = chain.request()
            with(chain) {
                proceed(
                    request.newBuilder().addHeader(
                        "x-api-key",
                        "{$$.env.x-api-key}"
                    ).build()
                )
            }
        }

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging)

        return httpClient.build()
    }
}