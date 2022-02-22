package com.example.userslist.repositories

import com.example.userslist.BuildConfig
import com.example.userslist.global.Constants
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceGenerator {
    private val TIMEOUT_SECONDS: Long = if (BuildConfig.DEBUG) 60 else 15

    fun <S> createService(serviceClass: Class<S>): S {
        return createService(Constants.BASE_HOST_URL, serviceClass)
    }

    fun <S> createService(baseUrl: String, serviceClass: Class<S>): S {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().apply {
                    connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    if (BuildConfig.DEBUG) {
                        addInterceptor(OkHttpProfilerInterceptor())
                    }
                }.build()
            ).build()
        return retrofit.create(serviceClass)
    }
}