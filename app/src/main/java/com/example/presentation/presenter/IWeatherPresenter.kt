package com.example.presentation.presenter

import com.example.presentation.ui.base.WeatherView


/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
interface IWeatherPresenter {
    fun getWeather(city:String)
    fun onCreate(view: WeatherView)
    fun onDestory()
}