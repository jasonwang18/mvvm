package com.android.jason.baiduweather.model.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangshizhan on 16/10/23.
 */

public class Result extends BaseObservable implements Serializable {

    public String currentCity;

    public String pm25;

    @SerializedName("index")
    public List<Index> index;

    @SerializedName("weather_data")
    public List<WeatherData> weatherDatas;


    public List<WeatherData> getWeatherDatas() {
        return weatherDatas;
    }

    public void setWeatherDatas(List<WeatherData> weatherDatas) {
        this.weatherDatas = weatherDatas;
    }

    public List<Index> getIndex() {
        return index;
    }

    public void setIndex(List<Index> index) {
        this.index = index;
    }

    @Bindable
    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    @Bindable
    public String getPm25() {
        return "PM 2.5浓度:"+pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }
}
