package com.example.domain.usercaseimpl

import com.example.data.bean.response.Weather
import io.reactivex.Observer

/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
interface WeatherUserCase {
    fun getWeather(city:String,observer: Observer<Weather>)
}