package com.android.jason.baiduweather.viewmodel;

import com.android.jason.baiduweather.common.presenter.IBasePresenter;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by wangshizhan on 16/10/26.
 */

public abstract class BaseViewModel<T, IV extends IBasePresenter> {


    protected IV iv;


    public BaseViewModel(IV iv){
        this.iv = iv;
        init();
    }


    protected void init() {

    }


    public void getData(){

    }

    protected void updateData(T t){

    }

    private Timer timer;
    private TimerTask timerTask;
    private TimerCountListener listener;

    protected void startTimer(final TimerCountListener listener){

        if(listener != null){
            this.listener = listener;
        }

        if(timer != null){
            timer.cancel();
        }
        else{
            timer = new Timer();
        }

        if(timerTask == null){
            timerTask  = new TimerTask() {
                @Override
                public void run() {
                    listener.onTimerFinish();
                }
            };
        }

        timer.schedule(timerTask, 0, 60000);
    }

    protected void cancelTimer(){

        if (timer != null) {
            timer.cancel();
            timer = null;
        }

        if (timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }

        listener = null;
    }

    interface TimerCountListener{

        void onTimerFinish();

    }

}
