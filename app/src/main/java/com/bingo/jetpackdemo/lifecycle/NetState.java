package com.bingo.jetpackdemo.lifecycle;

/**
 * ================================
 *
 * @author: zcb
 * @email: zcbin2@grgbanking.com
 * @time: 2020-02-13 14:35
 * @version: 1.0
 * @description: =================================
 */
public class NetState {
    public String getResponseCode() {
        return responseCode == null ? "" : responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    private String responseCode;
    private boolean success = true;

}
