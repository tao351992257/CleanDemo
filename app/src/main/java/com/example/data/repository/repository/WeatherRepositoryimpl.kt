package com.example.data.repository.repository

import com.example.data.bean.response.Weather
import com.example.data.network.ApiRetrofit
import com.example.data.repository.repositoryimpl.WeatherRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
class WeatherRepositoryimpl @Inject constructor() : WeatherRepository {
    override fun getWeather(city: String): Observable<Weather> {
        return ApiRetrofit.getInstance().getWeather(city)
    }

}