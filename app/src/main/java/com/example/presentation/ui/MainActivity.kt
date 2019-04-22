package com.example.presentation.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.R
import com.example.data.bean.response.Weather
import com.example.presentation.di.components.DaggerWeatherComponent
import com.example.presentation.di.modules.ActivityModules
import com.example.presentation.di.modules.WeatherModules
import com.example.presentation.presenter.WeatherPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), WeatherView {
    override fun showToast(t: Weather) {

        var weatherString: String?
        weatherString = "${t.lives[0].province}${t.lives[0].city}${t.lives[0].humidity}${t.lives[0].weather}"

        Toast.makeText(this@MainActivity, weatherString, Toast.LENGTH_SHORT).show()
    }

    @Inject
    lateinit var mWeatherPresenter: WeatherPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerWeatherComponent.builder()
            .weatherModules(WeatherModules())
            .build().inject(this)
        mWeatherPresenter.onCreate(this)
        btn_request_weather.setOnClickListener {
            mWeatherPresenter.getWeather("130635")
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        mWeatherPresenter.onDestory()
    }
}
