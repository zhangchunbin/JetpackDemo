package com.bingo.jetpackdemo.lifecycle;

import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * ================================
 *
 * @author: zcb
 * @email: zcbin2@grgbanking.com
 * @time: 2020-02-13 11:10
 * @version: 1.0
 * @description: 使用lifecycle 实现定位监听和位置变化更新
 * =================================
 */
public class MyLocationListener implements LifecycleObserver {
    private boolean enabled=false;
    private Context context;
    private Lifecycle lifecycle;
    private Callback callback;

    public MyLocationListener(Context context, Lifecycle lifecycle,Callback callback) {
        this.callback=callback;
        this.context=context;
        this.lifecycle=lifecycle;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void start(){
        if (enabled){
            //开始连接
        }
    }

    public void enabled(){
        enabled=true;
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)){

        }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void stop(){

    }





    public interface Callback{
        void change();
    }
}
