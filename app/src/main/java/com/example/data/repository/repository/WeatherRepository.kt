package com.example.data.repository.repository

import com.example.data.bean.response.WeatherReponse
import com.example.data.network.ApiRetrofit
import com.example.data.repository.repositoryimpl.IWeatherRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
class WeatherRepository @Inject constructor() : IWeatherRepository {
    override fun getWeather(city: String): Observable<WeatherReponse> {
        return ApiRetrofit.getInstance().getWeather(city)
    }

}