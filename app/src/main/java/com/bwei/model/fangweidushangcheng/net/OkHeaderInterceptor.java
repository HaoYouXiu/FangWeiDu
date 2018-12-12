package com.bwei.model.fangweidushangcheng.net;

import android.content.Context;
import android.content.SharedPreferences;

import com.bwei.model.fangweidushangcheng.app.App;

import java.io.IOException;
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

    SharedPreferences mSharedPreferences = App.scontext.getSharedPreferences( "tou", Context.MODE_PRIVATE);

    public OkHeaderInterceptor(){

    }
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        builder.addHeader("version","version1.0");
        builder.addHeader("platform","android");
        builder.addHeader("sessionId", (String) mSharedPreferences.getString(Constant.TOKEN,"") );
        builder.addHeader("userId", (String) mSharedPreferences.getString(Constant.USER_ID,"") );

        request = builder.build();
        return chain.proceed(request);
    }
}
