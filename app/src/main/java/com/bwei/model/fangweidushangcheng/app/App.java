package com.bwei.model.fangweidushangcheng.app;

import android.app.Application;
import android.content.Context;

import com.bwei.model.fangweidushangcheng.Util.LogUtil;
import com.bwei.model.fangweidushangcheng.net.OkHttpPost;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.HashMap;

/**
 * date:2018/12/4
 * author:郝仁（Thinkpad)
 * function:初始化页面
 */
public class App extends Application{

    public static Context scontext;

    @Override
    public void onCreate() {
        super.onCreate();
        scontext = this;
        Fresco.initialize( this );
        LogUtil.init();
        initHttpHeader();

    }

    private void initHttpHeader() {
        HashMap<String, String> hashMaps = new HashMap<>();
        hashMaps.put("token","this is token");
        hashMaps.put("version","version1.0");
        hashMaps.put("platform","android");
        OkHttpPost.init();
    }
}
