package com.android.jason.baiduweather.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangshizhan on 16/10/24.
 */

public class WeatherApiData implements Serializable{

    public int error;

    public String status;

    public String date;

    public List<Result> results;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
