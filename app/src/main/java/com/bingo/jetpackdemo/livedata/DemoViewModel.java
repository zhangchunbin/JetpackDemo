package com.bingo.jetpackdemo.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * ================================
 *
 * @author: ZCB
 * @email: zcbin2@grgbanking.com
 * @time: 2020/2/10 16:20
 * @version: 1.0
 * @description:
 * =================================
 */
public class DemoViewModel extends ViewModel {

    private MutableLiveData<String> myString =new MutableLiveData<>();

    public MutableLiveData<String> getMyString() {
        return myString;
    }

    public void setMyString(MutableLiveData<String> myString) {
        this.myString = myString;
    }
}
