package com.example.presentation.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import com.example.data.bean.response.WeatherReponse
import com.example.presentation.di.components.DaggerWeatherComponent
import com.example.presentation.di.modules.WeatherModules
import com.example.presentation.presenter.IWeatherPresenter
import com.example.presentation.ui.view.toast.ToastView
import javax.inject.Inject

/**
 *  Author : JinTao Li
 *  Create Time : 2019/7/9
 */
abstract class BaseActivity : AppCompatActivity(), WeatherView {
    @Inject
    lateinit var mIWeatherPresenter: IWeatherPresenter
    private var toastView: ToastView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerWeatherComponent.builder()
            .weatherModules(WeatherModules())
            .build().inject(this)
        mIWeatherPresenter.onCreate(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mIWeatherPresenter.onDestory()
    }

    override fun showToast(message: String) {
        showToastView(message)
    }

    override fun showData(weatherReponse: WeatherReponse) {}

    private fun showToastView(message: String?) {
        if (TextUtils.isEmpty(message)) {
            return
        }
        if (toastView == null) {
            toastView = ToastView(this)
        }
        toastView?.showToast(message)
    }
}