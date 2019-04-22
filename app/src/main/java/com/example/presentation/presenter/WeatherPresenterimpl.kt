package com.example.presentation.presenter

import com.example.data.bean.response.Weather
import com.example.domain.usercaseimpl.WeatherUserCase
import com.example.presentation.ui.WeatherView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
class WeatherPresenterimpl @Inject constructor() : WeatherPresenter {
    override fun onDestory() {
        mView = null
    }

    private var mView: WeatherView? = null
    override fun onCreate(view: WeatherView) {
        mView = view
    }

    @Inject
    lateinit var mWeatherUserCase: WeatherUserCase

    override fun getWeather(city: String) {


        mWeatherUserCase.getWeather(city, object : Observer<Weather> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: Weather) {
                    if (mView != null) {
                        mView?.showToast(t)
                    }
                }

                override fun onError(e: Throwable) {

                }

            })
    }
}

