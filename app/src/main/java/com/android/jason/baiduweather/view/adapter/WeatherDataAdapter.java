package com.android.jason.baiduweather.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.jason.baiduweather.R;
import com.android.jason.baiduweather.model.bean.WeatherData;
import com.android.jason.baiduweather.databinding.ItemWeatherDataBinding;

import java.util.List;

/**
 * Created by wangshizhan on 16/10/25.
 */

public class WeatherDataAdapter extends BaseBindingAdapter<WeatherData, ItemWeatherDataBinding> {

    public WeatherDataAdapter(Context context, List<WeatherData> weatherDatas) {
        super(context, weatherDatas);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        bindChildHolder((BaseBindingHolder)holder, position);
    }

    @Override
    protected void bindChildHolder(BaseBindingHolder holder, int position) {
        WeatherData weatherData = list.get(position);
        holder.binding.setVariable(com.android.jason.baiduweather.BR.weatherData, weatherData);
        holder.binding.executePendingBindings();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_weather_data;
    }

}
