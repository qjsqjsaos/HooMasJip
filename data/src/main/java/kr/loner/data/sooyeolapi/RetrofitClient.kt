package kr.loner.data.sooyeolapi

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kr.loner.shared.BlogType
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
            .baseUrl(if(type == BlogType.Naver) "https://openapi.naver.com" else "https://openapi.naver.com")
            .addConverterFactory(factroyJson.asConverterFactory("application/json".toMediaType()))
            .client(client)
            .build()
        return retrofit
    }

}

