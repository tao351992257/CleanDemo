package com.example.presentation.di.components

import com.example.presentation.di.modules.WeatherModules
import com.example.presentation.ui.activity.MainActivity
import com.example.presentation.ui.base.BaseActivity
import dagger.Component

/**
 * Created by : JinTao Li
 * Created time : 2019/4/17
 */
@Component(modules = [WeatherModules::class])
interface WeatherComponent {
    fun inject(activity: BaseActivity)
}