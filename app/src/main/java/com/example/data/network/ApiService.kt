package com.example.data.network

import com.example.data.bean.response.WeatherReponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
interface ApiService {
    @GET("weatherInfo?&key=f4181ce5e9f1faf6c19cb6f04a2a3cab")
    fun getWeather(@Query("city") city: String): Observable<WeatherReponse>
}