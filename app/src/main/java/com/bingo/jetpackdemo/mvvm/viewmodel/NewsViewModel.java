package com.bingo.jetpackdemo.mvvm.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bingo.jetpackdemo.mvvm.model.NewsModel;
import com.bingo.jetpackdemo.repository.net.callback.ResultCallback;
import com.lzy.okgo.OkGo;

import java.util.List;

/**
 * ================================
 *
 * @author: ZCB
 * @email: zcbin2@grgbanking.com
 * @time: 2020/2/8 16:58
 * @version: 1.0
 * @description: =================================
 */
public class NewsViewModel extends ViewModel {
    public static final String TAG="NewsViewModel";

    private MutableLiveData<List<NewsModel.ResultBean.DataBean>> datas = new MutableLiveData<>();


    public MutableLiveData<List<NewsModel.ResultBean.DataBean>> getDatas() {
        loadNewsData();
        return datas;
    }

    public void setDatas(MutableLiveData<List<NewsModel.ResultBean.DataBean>> datas) {
        this.datas = datas;
    }



    public void loadNewsData() {
        OkGo.<NewsModel>get("http://v.juhe.cn/toutiao/index?type=top&key=5af0a1611a13f41eb58f35f7c46b1625")
                .tag("news")
                .execute(new ResultCallback<NewsModel>() {

                    @Override
                    public void success(NewsModel newsBean) {
                        Log.i(TAG, "onNext: ");
                        datas.setValue(newsBean.getResult().getData());

                    }

                    @Override
                    public void error(int code, String msg) {
                        Log.i(TAG, "onError: " + msg);
                    }
                });
    }










}
