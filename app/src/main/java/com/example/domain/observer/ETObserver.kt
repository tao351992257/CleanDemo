package com.example.domain.observer

import com.example.presentation.ui.base.WeatherView
import io.reactivex.observers.DisposableObserver

/**
 *  Author : JinTao Li
 *  Create Time : 2019/7/9
 */
abstract class ETObserver<T>(private val view: WeatherView?) : DisposableObserver<T>() {
    override fun onComplete() {

    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        onFail(e)
    }

    abstract fun onSuccess(t: T)

    abstract fun onFail(e: Throwable)
}