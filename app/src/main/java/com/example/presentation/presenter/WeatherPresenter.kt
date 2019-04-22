package com.example.presentation.presenter

import com.example.presentation.ui.WeatherView


/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
interface WeatherPresenter {
    fun getWeather(city:String)
    fun onCreate(view:WeatherView)
    fun onDestory()
}