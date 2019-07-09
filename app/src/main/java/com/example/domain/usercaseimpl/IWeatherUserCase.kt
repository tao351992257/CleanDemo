package com.example.domain.usercaseimpl

import com.example.data.bean.response.WeatherReponse
import com.example.domain.observer.ETObserver

/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
interface IWeatherUserCase {
    fun getWeather(city:String,etObserver: ETObserver<WeatherReponse>)
}