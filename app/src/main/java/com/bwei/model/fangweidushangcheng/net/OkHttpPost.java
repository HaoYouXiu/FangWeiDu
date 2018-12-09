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

    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_PUP = "PUT";
    private static final String METHOD_DELETE = "DELETE";
    private static final Gson gson = new Gson();
    private static OkHttpClient okHttpClient;

    public static void init(Map headers) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(3000, TimeUnit.MILLISECONDS);
        builder.writeTimeout(3000, TimeUnit.MILLISECONDS);
        builder.readTimeout(3000, TimeUnit.MILLISECONDS);
        //添加请求头
        builder.addInterceptor(new OkHeaderInterceptor(headers));
        //添加log日志s
        builder.addInterceptor(new OkLogInterceptor());
        okHttpClient = builder.build();
    }

    //RequestGet是个空类
    private static Request createRequest(String url, String method, RequestGet requestGet) {
        RequestBody requestBody = null;
        if (requestBody != null) {
            String toJson = gson.toJson(requestGet);
            MediaType parse = MediaType.parse("application/json; charset=utf-8");
            requestBody = requestBody.create(parse, toJson);
        }
        Request.Builder builder = new Request.Builder().url(url);
        Request request = null;
        switch (method) {
            case METHOD_GET:
                request = builder.get().build();
                break;
            case METHOD_POST:
                request = builder.post(requestBody).build();
                break;
            case METHOD_PUP:
                if (requestBody != null) {
                    request = builder.put(requestBody).build();
                }
                break;
            case METHOD_DELETE:
                if (requestBody != null) {
                    request = builder.delete(requestBody).build();
                } else {
                    request = builder.delete().build();
                }

                break;
        }
        return request;
    }

    private static Request createRequst(String url, String method, Map<String, String> requestGet) {
        FormBody.Builder form = new FormBody.Builder();
        Set set = requestGet.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = (String) iterator.next();
            form.add(next, requestGet.get(next));
        }
        FormBody formBody = form.build();
        Request.Builder builder = new Request.Builder().url(url);
        Request request = null;
        switch (method) {
            case METHOD_GET:
                request = builder.get().build();
                break;
            case METHOD_POST:
                request = builder.post(formBody).build();
                break;
            case METHOD_PUP:
                if (formBody != null) {
                    request = builder.put(formBody).build();
                }
                break;
            case METHOD_DELETE:
                if (formBody != null) {
                    request = builder.delete(formBody).build();
                } else {
                    request = builder.delete().build();
                }
                break;
        }
        return request;
    }

    public static void EnestenPost(String url, RequestGet requestGet,Callback callback){
        Request request = createRequest(url,METHOD_POST, requestGet);
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
    public static void EnestenPost(String url, Map requestGet, Callback callback){
        Request request = createRequst(url, METHOD_POST, requestGet);
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
    public static void EnestenGet(String url, Callback callback){
        Request request = createRequest(url, METHOD_GET, null);
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

}
