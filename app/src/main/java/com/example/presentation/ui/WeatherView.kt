package com.example.presentation.ui

import com.example.data.bean.response.Weather

/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
interface WeatherView {
    fun showToast(t:Weather)
}