package com.example.presentation.di.modules

import com.example.data.repository.repository.WeatherRepository
import com.example.data.repository.repositoryimpl.IWeatherRepository
import com.example.domain.usercase.WeatherUseCases
import com.example.domain.usercaseimpl.IWeatherUserCase
import com.example.presentation.presenter.IWeatherPresenter
import com.example.presentation.presenter.WeatherPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by : JinTao Li
 * Created time : 2019/4/17
 */
@Module
class WeatherModules {

    @Provides
    fun provideWeatherPresenter(weatherPresenter: WeatherPresenter): IWeatherPresenter {
        return weatherPresenter
    }

    @Provides
    fun provideWeatherRepository(weatherRepository: WeatherRepository): IWeatherRepository {
        return weatherRepository
    }

    @Provides
    fun provideWeatherUserCase(weatherUserCaseimpl: WeatherUseCases): IWeatherUserCase {
        return weatherUserCaseimpl
    }

}