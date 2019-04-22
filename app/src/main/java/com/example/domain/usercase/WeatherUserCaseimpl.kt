package com.example.domain.usercase

import com.example.data.bean.response.Weather
import com.example.data.repository.repositoryimpl.WeatherRepository
import com.example.domain.usercaseimpl.WeatherUserCase
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
class WeatherUserCaseimpl @Inject constructor(private var mWeatherRepository: WeatherRepository) : WeatherUserCase {
    override fun getWeather(city: String, observer: Observer<Weather>) {
        mWeatherRepository.getWeather(city)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)

    }
}