package com.android.jason.baiduweather.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.android.jason.baiduweather.MyApplication;
import com.android.jason.baiduweather.R;
import com.android.jason.baiduweather.common.presenter.IBindingPresenter;
import com.android.jason.baiduweather.databinding.ActivityMainBinding;
import com.android.jason.baiduweather.model.bean.Result;
import com.android.jason.baiduweather.model.bean.WeatherApiData;
import com.android.jason.baiduweather.model.bean.WeatherData;
import com.android.jason.baiduweather.view.adapter.IndexAdapter;
import com.android.jason.baiduweather.view.adapter.WeatherDataAdapter;
import com.android.jason.baiduweather.viewmodel.MainActivityViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements IBindingPresenter<WeatherApiData> {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initBinding() {
        binding.weatherDataRecyclerView.setHasFixedSize(true);
        binding.weatherDataRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 4));
        binding.weatherDataRecyclerView.setItemAnimator(new DefaultItemAnimator());

        binding.indexRecyclerView.setHasFixedSize(true);
        binding.indexRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 4));
        binding.indexRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void createViewModel() {
        viewModel = new MainActivityViewModel(this);
    }

    public void geiWeatherData(View view){

        viewModel.getData();
    }


    @Override
    public void createBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    public void updateBinding(WeatherApiData weatherApiData) {

        if(weatherApiData == null){
            return;
        }

        if(weatherApiData.getResults() == null){
            return;
        }

        if (weatherApiData.getResults().size() == 0) {
            return;
        }

        Result result = weatherApiData.getResults().get(0);
        binding.setWeatherResult(result);

        if(result.getWeatherDatas() == null){
            return;
        }

        WeatherData weatherDataToday = result.getWeatherDatas().get(0);
        binding.setWeatherdataToday(weatherDataToday);

        updateRecyclerViewAdapter(result);
    }

    private void updateRecyclerViewAdapter(Result result){
        IndexAdapter indexAdapter = new IndexAdapter(MyApplication.getApplication(), result.getIndex());
        binding.indexRecyclerView.setAdapter(indexAdapter);

        WeatherDataAdapter weatherDataAdapter = new WeatherDataAdapter(MyApplication.getApplication(),
                result.getWeatherDatas());
        binding.weatherDataRecyclerView.setAdapter(weatherDataAdapter);
    }

}
