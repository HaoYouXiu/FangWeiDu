package com.bwei.model.fangweidushangcheng.net;

import com.bwei.model.fangweidushangcheng.Util.LogUtil;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * date:2018/12/4
 * author:郝仁（Thinkpad)
 * function: okhttp3的日志拦截器
 *这个拦截器的主要功能是让我们提供请求参数日志的打印
 */
public class OkLogInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        String method= request.method();
        HttpUrl url = request.url();
        LogUtil.d("本次请求", "ulr" + url.toString() + "method:" + method);

        Headers headers = request.headers();
        Set<String> names = headers.names();
        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()){
            String next = iterator.next();
            String value = headers.get(next);
            LogUtil.d(next + ":" + value);
        }
        return chain.proceed(request);
    }
}
