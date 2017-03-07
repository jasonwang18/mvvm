package com.android.jason.baiduweather.model.network;

import com.android.jason.baiduweather.common.constant.HttpConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by wangshizhan on 16/10/22.
 */

public class BaseClient {

    private OkHttpClient defaultClient;

    protected Retrofit retrofit;

    public BaseClient(){
        // 设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(HttpConstants.Timeout.DEFAULT_CONNECT, TimeUnit.SECONDS)
                .readTimeout(HttpConstants.Timeout.DEFAULT_READ, TimeUnit.SECONDS)
                .writeTimeout(HttpConstants.Timeout.DEFAULT_WRITE, TimeUnit.SECONDS);
        defaultClient = builder.build();
    }

    public OkHttpClient getDefaultClient() {
        return defaultClient;
    }
}
