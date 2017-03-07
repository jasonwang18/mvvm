package com.android.jason.baiduweather.model.network;

import com.android.jason.baiduweather.common.constant.APIConstant;
import com.android.jason.baiduweather.model.api.IRetrofit;
import com.android.jason.baiduweather.model.api.IRetrofitWeather;
import com.android.jason.baiduweather.model.bean.WeatherApiData;
import com.android.jason.baiduweather.model.factory.ApiFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wangshizhan on 16/10/26.
 */

public class RetrofitClient extends BaseClient implements IRetrofit {

    private static RetrofitClient instance;

    private RetrofitClient(){
        super();
        retrofit = new Retrofit.Builder()
                .baseUrl(APIConstant.URL.BAIDU_WEATHER_BASE_URL)
                .client(getDefaultClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void getWeather(String location, Callback<WeatherApiData> callback) {

        IRetrofitWeather api = retrofit.create(IRetrofitWeather.class);

        Call<WeatherApiData> call = api.getWeather(location, APIConstant.URL.OUTPUT, APIConstant.URL.AK);

        call.enqueue(callback);

    }

    public static IRetrofit build(){

            if (null == instance) {
                synchronized (ApiFactory.class) {
                    if (null == instance) {
                        instance = new RetrofitClient();
                    }
                }
        }

        return instance;

    }


}
