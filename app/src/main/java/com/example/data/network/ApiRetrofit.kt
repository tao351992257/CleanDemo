package com.example.data.network

import android.content.Context
import com.example.data.bean.response.Weather
import com.example.data.entity.AppUrl
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
class ApiRetrofit constructor() : BaseApiRetrofit() {


    val mOkHttp by lazy {
        Retrofit.Builder()
            .baseUrl(AppUrl.BASE_URL)
            .client(getOkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    companion object {
        private var apiRetrofit: ApiRetrofit? = null
        fun getInstance(): ApiRetrofit {
            if (apiRetrofit == null) {
                synchronized(ApiRetrofit::class.java) {
                    apiRetrofit = ApiRetrofit()
                }
            }
            return apiRetrofit!!
        }
    }

    fun getWeather(city: String): Observable<Weather> {
        return mOkHttp.getWeather(city)
    }
}