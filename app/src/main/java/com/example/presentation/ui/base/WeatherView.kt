package com.example.presentation.ui.base

import com.example.data.bean.response.WeatherReponse


/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
interface WeatherView {
    fun showToast(message: String)
    fun showData(weatherReponse: WeatherReponse)
}