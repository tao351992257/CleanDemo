package com.example.presentation.di.modules

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 * Created by : JinTao Li
 * Created time : 2019/4/19
 */
@Module
class ActivityModules {
    @Provides
    fun activity(): Activity {
        return activity()
    }
}