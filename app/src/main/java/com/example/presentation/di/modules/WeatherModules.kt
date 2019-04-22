package com.example.presentation.di.modules

import com.example.data.repository.repository.WeatherRepositoryimpl
import com.example.data.repository.repositoryimpl.WeatherRepository
import com.example.domain.usercase.WeatherUserCaseimpl
import com.example.domain.usercaseimpl.WeatherUserCase
import com.example.presentation.presenter.WeatherPresenter
import com.example.presentation.presenter.WeatherPresenterimpl
import com.example.presentation.ui.MainActivity
import com.example.presentation.ui.WeatherView
import dagger.Module
import dagger.Provides

/**
 * Created by : JinTao Li
 * Created time : 2019/4/17
 */
@Module
class WeatherModules {

    @Provides
    fun provideWeatherPresenter(weatherPresenterimpl: WeatherPresenterimpl): WeatherPresenter {
        return weatherPresenterimpl
    }

    @Provides
    fun provideWeatherRepository(weatherRepositoryimpl: WeatherRepositoryimpl): WeatherRepository {
        return weatherRepositoryimpl
    }

    @Provides
    fun provideWeatherUserCase(weatherUserCaseimpl: WeatherUserCaseimpl): WeatherUserCase {
        return weatherUserCaseimpl
    }

}