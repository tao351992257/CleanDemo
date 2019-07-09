package com.example.data.network

import android.util.Log
import com.example.data.entity.AppUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit

/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
open class BaseApiRetrofit {

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(AppUrl.BASE_URL)
            .client(mOkHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    private val mOkHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)//连接超时设置
            .writeTimeout(30, TimeUnit.SECONDS)//写入超时设置，
            .readTimeout(30, TimeUnit.SECONDS)//读取超时设置
            .addInterceptor(LogInterceptor())
            .build()
    }

    private inner class LogInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            val response = chain.proceed(request)
            val requestTime = System.nanoTime()
            Log.d(
                "Log",
                "intercept(BaseApiRetrofit.kt:40)------>${String.format(
                    "发起请求:%s on %s%n%s%s",
                    request.url(),
                    chain.connection(),
                    request.headers(),
                    request.body().toString()
                )}"
            )
            val responseTime = System.nanoTime()
            Log.d(
                "Log", "intercept(BaseApiRetrofit.kt:51)------>${String.format(
                    "接收响应: [%s] %n返回json:[%s] %.1fms%n%s", response.request().url(),
                    getResponseString(response),
                    (responseTime - requestTime) / 1e6,
                    response.headers()
                )}"
            )
            return response
        }
    }

    private fun getResponseString(response: Response?): String? {
        return try {
            val responseBody = response?.body()
            val source = responseBody?.source()
            source?.request(Long.MAX_VALUE)
            val buffer = source?.buffer()
            buffer?.clone()?.readString(Charset.forName("UTF-8"))
        } catch (e: Exception) {
            e.toString()
            null
        }
    }


}