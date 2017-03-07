package com.android.jason.baiduweather.model.api;

import com.android.jason.baiduweather.model.bean.WeatherApiData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by wangshizhan on 16/10/26.
 */

public interface IRetrofitWeather {

    /**
     * retrofit 封装
     * @param location
     */
    @FormUrlEncoded
    @POST("telematics/v3/weather?")
    Call<WeatherApiData> getWeather(@Field("location") String location,
                                  @Field("output") String ouput,
                                  @Field("ak") String ak);


}
