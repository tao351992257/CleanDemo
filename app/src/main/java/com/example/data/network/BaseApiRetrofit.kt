package com.example.data.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
open class BaseApiRetrofit {

    private val mOkHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)//连接超时设置
            .writeTimeout(30, TimeUnit.SECONDS)//写入超时设置，
            .readTimeout(30, TimeUnit.SECONDS)//读取超时设置
            .addInterceptor(getOkHttpInterceptor())
            .build()
    }

    fun getOkHttpClient(): OkHttpClient {
        return mOkHttpClient
    }

    fun getOkHttpInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }


}