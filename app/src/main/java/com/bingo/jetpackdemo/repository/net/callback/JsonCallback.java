package com.bingo.jetpackdemo.repository.net.callback;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.lzy.okgo.callback.AbsCallback;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * ================================
 *
 * @author: ZCB
 * @email: zhang-cb@foxmail.com
 * @time: 2019/9/1 21:36
 * @version: 1.0
 * @description: =================================
 */
public abstract class JsonCallback extends AbsCallback<JsonObject> {



    @Override
    public JsonObject convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body == null){
            return null;
        }

        JsonObject data = null;
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(body.charStream());

        data = gson.fromJson(jsonReader, JsonObject.class);
        return data;
    }

    @Override
    public void onSuccess(com.lzy.okgo.model.Response<JsonObject> response) {
        JsonObject t = response.body();
        if (t instanceof JsonObject){

        }
        int code= t.get("code").getAsInt();
        String msg = t.get("msg").getAsString();
        if (code==200){
            success(t);
        }else{
            error(code,msg==null?"":msg);
        }

    }

    @Override
    public void onError(com.lzy.okgo.model.Response<JsonObject> response) {
        super.onError(response);
        int errorCode = response.code();
        String msg = response.message();
        error(errorCode,msg);
    }


    public abstract void success(JsonObject t);
    public abstract void error(int code, String msg);
}
