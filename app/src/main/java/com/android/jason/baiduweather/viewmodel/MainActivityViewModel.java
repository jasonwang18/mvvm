package com.android.jason.baiduweather.viewmodel;

import android.widget.Toast;

import com.android.jason.baiduweather.MyApplication;
import com.android.jason.baiduweather.common.presenter.IBindingPresenter;
import com.android.jason.baiduweather.common.util.LogUtil;
import com.android.jason.baiduweather.model.bean.WeatherApiData;
import com.android.jason.baiduweather.model.factory.ApiFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wangshizhan on 16/10/26.
 */

public class MainActivityViewModel extends BaseViewModel<WeatherApiData, IBindingPresenter<WeatherApiData>>{


    public MainActivityViewModel(IBindingPresenter iv) {
        super(iv);
    }

    @Override
    protected void init() {
        super.init();


        startTimer(new TimerCountListener() {
            @Override
            public void onTimerFinish() {
                getData();
            }

        });
    }



    @Override
    public void getData() {
        getWeather();
    }

    private void getWeather() {

        ApiFactory.getInstance().createRetrofitClient().getWeather("杭州", new Callback<WeatherApiData>() {

            @Override
            public void onResponse(Call<WeatherApiData> call, Response<WeatherApiData> response) {
                WeatherApiData weatherApiData = response.body();
                iv.updateBinding(weatherApiData);
            }

            @Override
            public void onFailure(Call<WeatherApiData> call, Throwable t) {
                LogUtil.i("error:"+t.getMessage());
                Toast.makeText(MyApplication.getApplication(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }

        });

    }


}
