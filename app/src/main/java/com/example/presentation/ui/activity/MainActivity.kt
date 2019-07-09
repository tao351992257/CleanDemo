package com.example.presentation.ui.activity

import android.os.Bundle
import com.example.R
import com.example.data.bean.response.WeatherReponse
import com.example.presentation.ui.base.BaseActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_request_weather.setOnClickListener {
            mIWeatherPresenter.getWeather("130635")
        }
    }

    override fun showData(weatherReponse: WeatherReponse) {
        tv_response.text = Gson().toJson(weatherReponse)
    }
}
