package com.example.presentation.di.components

import com.example.presentation.di.modules.WeatherModules
import com.example.presentation.ui.MainActivity
import dagger.Component

/**
 * Created by : JinTao Li
 * Created time : 2019/4/17
 */
@Component(modules = [WeatherModules::class])
interface WeatherComponent {
    fun inject(activity: MainActivity)
}