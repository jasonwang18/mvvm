package com.android.jason.baiduweather.view;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.jason.baiduweather.viewmodel.BaseViewModel;

/**
 * Created by wangshizhan on 16/10/26.
 */

public abstract class BaseActivity<B> extends AppCompatActivity{

    protected BaseViewModel viewModel;
    protected B binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createBinding();
        createViewModel();
        initBinding();
    }

    protected abstract void initBinding();

    protected abstract void createBinding();


    protected abstract void createViewModel();

}
