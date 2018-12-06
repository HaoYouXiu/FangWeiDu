package com.bwei.model.fangweidushangcheng.net;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * date:2018/12/5
 * author:郝仁（Thinkpad)
 * function:okhttp3的请求头拦截器
 * 这个里面主要的功能是让我们添加公共的请求头
 */
public class OkHeaderInterceptor implements Interceptor {
    private Map<String, String> headers;

    public OkHeaderInterceptor(Map<String, String> headers) {
        this.headers = headers;

        this.headers = headers;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        if (headers != null){
            Set set = headers.keySet();
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()){
                String next = iterator.next();
                builder.addHeader(next, headers.get(next));
            }
        }
        request = builder.build();
        return chain.proceed(request);
    }
}
