package com.example.domain.usercase

import com.example.data.bean.response.WeatherReponse
import com.example.data.repository.repositoryimpl.IWeatherRepository
import com.example.domain.observer.ETObserver
import com.example.domain.usercaseimpl.IWeatherUserCase
import javax.inject.Inject

/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
class WeatherUseCases @Inject constructor(private var mIWeatherRepository: IWeatherRepository) : IWeatherUserCase,
    ExecuteUseCase() {
    override fun getWeather(city: String, etObserver: ETObserver<WeatherReponse>) {
        execute(etObserver, mIWeatherRepository.getWeather(city))
    }
}