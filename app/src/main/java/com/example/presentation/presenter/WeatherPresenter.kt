package com.example.presentation.presenter

import com.example.data.bean.response.WeatherReponse
import com.example.domain.observer.ETObserver
import com.example.domain.usercaseimpl.IWeatherUserCase
import com.example.presentation.ui.base.WeatherView
import com.google.gson.Gson
import javax.inject.Inject

/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
class WeatherPresenter @Inject constructor() : IWeatherPresenter {
    override fun onDestory() {
        view = null
    }

    private var view: WeatherView? = null
    override fun onCreate(view: WeatherView) {
        this.view = view
    }

    @Inject
    lateinit var mWeatherUserCase: IWeatherUserCase

    override fun getWeather(city: String) {


        mWeatherUserCase.getWeather(city, object : ETObserver<WeatherReponse>(view) {
            override fun onSuccess(t: WeatherReponse) {
                val weather = t.lives[0].weather
                view?.showToast(weather)
                view?.showData(t)
            }

            override fun onFail(e: Throwable) {
                view?.showToast(e.message.toString())
            }
        })
    }
}

