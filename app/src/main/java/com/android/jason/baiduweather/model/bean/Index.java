package com.android.jason.baiduweather.model.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.io.Serializable;

/**
 * Created by wangshizhan on 16/10/22.
 */

public class Index extends BaseObservable implements Serializable {

    public String title;

    public String zs;

    public String tips;

    public String des;

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Bindable
    public String getZs() {
        return zs;
    }

    public void setZs(String zs) {
        this.zs = zs;
    }

    @Bindable
    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    @Bindable
    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
