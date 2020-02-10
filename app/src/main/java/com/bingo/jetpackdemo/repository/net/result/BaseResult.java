package com.bingo.jetpackdemo.repository.net.result;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

/**
 * ================================
 *
 * @author: ZCB
 * @email: zhang-cb@foxmail.com
 * @time: 2019/9/1 22:51
 * @version: 1.0
 * @description:
 * =================================
 */
public class BaseResult extends BaseObservable {
    @SerializedName("error_code")
    private int errorCode;
    @SerializedName("reason")
    private String reason;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getReason() {
        return reason == null ? "" : reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
