package com.bwei.model.fangweidushangcheng.net;

import android.os.Handler;
import android.os.Message;

import com.bwei.model.fangweidushangcheng.Util.ToasUtil;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * date:2018/12/5
 * author:郝仁（Thinkpad)
 * function: 统一callback对象
 */
public class OkhttpCallBack implements Callback {

    private Handler mHandler = new Handler();
    private Gson mGson = new Gson();

    HttpDataListener mHttpDataListener;

    public OkhttpCallBack(HttpDataListener httpDataListener) {
        mHttpDataListener = httpDataListener;
    }

    @Override
    public void onFailure(Call call, final IOException e) {
        call.cancel();

        mHandler.post( new Runnable() {
            @Override
            public void run() {
                mHttpDataListener.httpfail("网请求失败");
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {

       switch (response.code()){
           case 200:
               deal200(call, response);
           break;
           case 304:
           case 307:
               //缓存
               deal300(call, response);
               break;
           case 400:
           case 404:
               //资源不存在
               deal400(call, response);
               break;
           case 500:
           case 504:
               //服务器错误
               deal500(call, response);
               break;
           default:
               //未知错误
               dealdefault(call, response);
               break;
       }
    }

    private void deal200(Call call, final Response response) throws IOException {

        mHandler.post( new Runnable() {
            @Override
            public void run() {
                String jsonData = null;
                try {
                    jsonData = response.body().string();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mHttpDataListener.httpSuccess(jsonData);
            }
        } );

    }
    private void deal300(Call call, Response response){

    }
    private void deal400(Call call, Response response){
        mHandler.post( new Runnable() {
            @Override
            public void run() {
                mHttpDataListener.httpfail("资源不存在");
            }
        } );


    }
    private void deal500(Call call, Response response){
        mHandler.post( new Runnable() {
            @Override
            public void run() {
                mHttpDataListener.httpfail("服务器错误");

            }
        } );

    }
    private void dealdefault(Call call, Response response){
        mHandler.post( new Runnable() {
            @Override
            public void run() {
                mHttpDataListener.httpfail("未知错误");
            }
        } );

    }
}
