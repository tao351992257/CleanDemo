package com.example.data.repository.repositoryimpl

import com.example.data.bean.response.Weather
import io.reactivex.Observable

/**
 * Created by : JinTao Li
 * Created time : 2019/4/16
 */
interface WeatherRepository {
    /**
     * 获取数据
     **/
    fun getWeather(city:String): Observable<Weather>
}