package com.android.jason.baiduweather.model.factory;

import com.android.jason.baiduweather.model.api.ICreateRetrofitClient;
import com.android.jason.baiduweather.model.api.IRetrofit;
import com.android.jason.baiduweather.model.network.RetrofitClient;

/**
 * Created by wangshizhan on 16/10/25.
 */

public class ApiFactory extends BaseApiFactory implements ICreateRetrofitClient {


    private static ApiFactory instance;

    public static ApiFactory getInstance() {
        if (null == instance) {
            synchronized (ApiFactory.class) {
                if (null == instance) {
                    instance = new ApiFactory();
                }
            }
        }
        return instance;
    }

    private ApiFactory(){


    }

    @Override
    public IRetrofit createRetrofitClient() {
        return RetrofitClient.build();
    }
}
