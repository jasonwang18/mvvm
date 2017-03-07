package com.android.jason.baiduweather.model.api;

import com.android.jason.baiduweather.model.bean.WeatherApiData;

import retrofit2.Callback;

/**
 * Created by wangshizhan on 16/10/27.
 */

public interface IRetrofit {

    void getWeather(String location, Callback<WeatherApiData> callback);


}
