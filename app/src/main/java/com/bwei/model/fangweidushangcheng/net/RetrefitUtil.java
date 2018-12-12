package com.bwei.model.fangweidushangcheng.net;

import com.bwei.model.fangweidushangcheng.Util.HttpUrl;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * date:2018/12/11
 * author:郝仁（Thinkpad)
 * function:
 */
public class RetrefitUtil {

    private static RetrefitUtil instance;
    private Retrofit mBuilder;

    private RetrefitUtil(){
        OkHttpClient builder = new OkHttpClient.Builder()
                .readTimeout( 3000, TimeUnit.MILLISECONDS )
                .writeTimeout( 3000, TimeUnit.MILLISECONDS )
                .build();
        mBuilder = new Retrofit.Builder()
                .baseUrl( HttpUrl.UTIL_URL )
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                .addConverterFactory( GsonConverterFactory.create() )
                .client( builder )
                .build();

    }

    public static RetrefitUtil getInstance(){
        if (instance == null){
            synchronized (RetrefitUtil.class){
                if (instance == null){
                    instance = new RetrefitUtil();
                }
            }
        }
        return instance;
    }

    public <T> T Create(Class<T> tClass){
        return mBuilder.create( tClass );
    }
}
