package com.example.data.network

import com.example.data.bean.response.WeatherReponse
import io.reactivex.Observable

/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
class ApiRetrofit : BaseApiRetrofit() {

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

    fun getWeather(city: String): Observable<WeatherReponse> {
        return apiService.getWeather(city)
    }
}