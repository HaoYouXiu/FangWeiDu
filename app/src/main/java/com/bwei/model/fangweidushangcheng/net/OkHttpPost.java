package com.bwei.model.fangweidushangcheng.net;

import com.google.gson.Gson;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * date:2018/12/4
 * author:郝仁（Thinkpad)
 * function:
 */
public class OkHttpPost {
    public OkHttpPost() {}
    private static OkHttpClient sOkHttpClient;

    private static Gson gson = new Gson();
    private static final String MEDIA_TAPE = "application/json;charset=utf-8";
    private static final String MEDIA_GET = "GET";
    private static final String MEDIA_POST = "POST";
    private static final String MEDIA_PUT = "PUT";
    private static final String MEDIA_DELETE = "DELETE";

    public static void init() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout( 3000, TimeUnit.MILLISECONDS );
        builder.writeTimeout( 3000, TimeUnit.MILLISECONDS );
        builder.connectTimeout( 3000, TimeUnit.MILLISECONDS );
        //添加请求头
        builder.addInterceptor(new OkHeaderInterceptor());
        //添加日志
        builder.addInterceptor(new OkLogInterceptor());
        sOkHttpClient = builder.build();
    }

    //BaseRequest自己定义的类
    private static Request createRequst(String url, String methodPost, BaseRequest baseRequest) {
        RequestBody requestBody = null;
        if (baseRequest == null) {
            String json = gson.toJson( baseRequest );
            MediaType parse = MediaType.parse( MEDIA_TAPE );
            requestBody = RequestBody.create( parse, json );
        }

        Request.Builder builder = new Request.Builder().url( url );
        Request request = null;
        switch (methodPost) {
            case MEDIA_GET:
                request = builder.build();
                break;
            case MEDIA_POST:
                request = builder.post( requestBody ).build();
                break;
            case MEDIA_PUT:
                if (request != null) {
                    request = builder.put( requestBody ).build();
                }
                break;
            case MEDIA_DELETE:
                if (requestBody != null) {
                    request = builder.delete( requestBody ).build();
                } else {
                    request = builder.delete().build();
                }
                break;
        }
        return request;
    }

    private static Request createRequestForm(String url, String methodPost, Map<String, String> baseRequest) {
        FormBody.Builder requestBoay = new FormBody.Builder();
        Set strings = baseRequest.keySet();
        Iterator iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = (String) iterator.next();
            requestBoay.add( next, baseRequest.get( next ) );
        }
        FormBody formBody = requestBoay.build();
        Request.Builder url1 = new Request.Builder().url( url );
        Request request = null;
        switch (methodPost) {
            case MEDIA_GET:
                request = url1.get().build();
                break;
            case MEDIA_POST:
                request = url1.post( formBody ).build();
                break;
            case MEDIA_PUT:
                if (formBody != null){
                    request = url1.put( formBody ).build();
                }
                break;
            case MEDIA_DELETE:
                if (formBody != null){
                    request = url1.delete(formBody).build();
                }else {
                    request = url1.delete().build();
                }
                break;
        }
        return request;
    }

    public static void enqueuPost(String url, BaseRequest baseRequest, Callback callback){
        Request requst = createRequst( url, MEDIA_POST, baseRequest );
        Call call = sOkHttpClient.newCall( requst );
        call.enqueue( callback );
    }

    public static void enqueuepost(String url, Map baseRequest, Callback callback){
        Request request = createRequestForm( url, MEDIA_POST, baseRequest);
        Call call = sOkHttpClient.newCall( request );
        call.enqueue( callback );
    }

    public static void enqueueGet(String url, BaseRequest baseRequest, Callback callback){
        Request request = createRequst( url, MEDIA_GET, baseRequest );
        Call call = sOkHttpClient.newCall( request );
        call.enqueue( callback );
    }

}
