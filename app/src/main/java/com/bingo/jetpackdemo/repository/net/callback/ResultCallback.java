package com.bingo.jetpackdemo.repository.net.callback;

import com.bingo.jetpackdemo.repository.net.result.BaseResult;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.lzy.okgo.callback.AbsCallback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * ================================
 *
 * @author: ZCB
 * @email: zhang-cb@foxmail.com
 * @time: 2019/9/1 21:50
 * @version: 1.0
 * @description: =================================
 */
public abstract class ResultCallback <T extends BaseResult> extends AbsCallback<T> {
    @Override
    public T convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body == null){
            return null;
        }

        T data = null;
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(body.charStream());

        Type genType = getClass().getGenericSuperclass();
        Type type = ((ParameterizedType)genType).getActualTypeArguments()[0];

        data = gson.fromJson(jsonReader,type);
        return data;
    }

    @Override
    public void onSuccess(com.lzy.okgo.model.Response<T> response) {
        T t = response.body();
        BaseResult baseResult = t;
        if (baseResult.getErrorCode()==0){
            success(t);
        }else {
            error(baseResult.getErrorCode(),baseResult.getReason());
        }
    }

    @Override
    public void onError(com.lzy.okgo.model.Response<T> response) {
        super.onError(response);
        Throwable throwable = response.getException();
        int errorCode = response.code();
        String msg = response.message();
        error(errorCode,msg);
    }


    public abstract void success(T t);
    public abstract void error(int code, String msg);


}
