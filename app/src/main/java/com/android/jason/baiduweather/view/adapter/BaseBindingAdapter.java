package com.android.jason.baiduweather.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.jason.baiduweather.R;
import com.android.jason.baiduweather.databinding.ItemIndexBinding;
import com.android.jason.baiduweather.databinding.ItemWeatherDataBinding;
import com.android.jason.baiduweather.model.bean.Index;
import com.android.jason.baiduweather.model.bean.WeatherData;

import java.util.List;

/**
 * Created by wangshizhan on 16/10/25.
 */

public abstract class BaseBindingAdapter<T, B extends ViewDataBinding> extends RecyclerView.Adapter {
    protected List<T> list;

    public class BaseBindingHolder extends RecyclerView.ViewHolder {
        protected B binding;

        public BaseBindingHolder(View v) {
            super(v);
        }

        public B getBinding() {
            return binding;
        }

        public void setBinding(B binding) {
            this.binding = binding;
        }
    }

    public BaseBindingAdapter(Context context, List<T> list) {
        this.list = list;
    }

    @Override
    public BaseBindingHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        B binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                getLayoutId(),
                parent,
                false);
        BaseBindingHolder holder = new BaseBindingHolder(binding.getRoot());
        holder.setBinding(binding);
        return holder;
    }

    protected abstract void bindChildHolder(BaseBindingHolder holder, int position);

    protected abstract int getLayoutId();

    @Override
    public int getItemCount() {
        return list.size();
    }
}
