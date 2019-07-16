package com.example.presentation.di.modules

import android.app.Activity
import com.example.presentation.di.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by : JinTao Li
 * Created time : 2019/4/19
 */

@Module
class ActivityModules(val activity: Activity) {
    @Provides
    @ActivityScope
    fun activity(): Activity {
        return this.activity
    }
}