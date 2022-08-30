package com.example.apisample.data

import com.example.apisample.presentation.widget.utils.Constants.DAUM_BASE_URL
import com.example.apisample.presentation.widget.utils.Constants.NAVER_BASE_URL
import com.example.apisample.shared.BlogType
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object RetrofitClient {

    private var retrofit: Retrofit? = null

    private val factroyJson = Json {
        isLenient = true
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    @OptIn(ExperimentalSerializationApi::class)
    fun getClient(type: BlogType): Retrofit? {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        retrofit = Retrofit.Builder()
            .baseUrl(if(type == BlogType.Naver) NAVER_BASE_URL else DAUM_BASE_URL)
            .addConverterFactory(factroyJson.asConverterFactory("application/json".toMediaType()))
            .client(client)
            .build()
        return retrofit
    }
}

