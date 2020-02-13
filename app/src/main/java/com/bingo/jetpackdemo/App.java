package com.bingo.jetpackdemo;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;

/**
 * ================================
 *
 * @author: ZCB
 * @email: zcbin2@grgbanking.com
 * @time: 2020/2/8 12:53
 * @version: 1.0
 * @description:
 * =================================
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        OkGo.getInstance().init(this)                       //必须调用初始化
                .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)   //全局统一缓存时间，默认永不过期，可以不传
                .setRetryCount(3);
    }
}
