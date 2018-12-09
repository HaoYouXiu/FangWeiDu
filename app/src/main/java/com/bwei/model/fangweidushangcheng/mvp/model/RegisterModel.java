package com.bwei.model.fangweidushangcheng.mvp.model;

import android.os.Handler;
import android.os.Message;

import com.bwei.model.fangweidushangcheng.bean.LoginBean;
import com.bwei.model.fangweidushangcheng.mvp.callback.LoginCallBack;
import com.bwei.model.fangweidushangcheng.Util.HttpUrlUtil;
import com.bwei.model.fangweidushangcheng.net.HttpDataListener;
import com.bwei.model.fangweidushangcheng.net.OkHttpPost;
import com.bwei.model.fangweidushangcheng.net.OkhttpCallBack;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * date:2018/12/1
 * author:郝仁（Thinkpad)
 * function:
 */
public class RegisterModel {

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage( msg );
        }
    };

    public void register(String userName, String password, final LoginCallBack RegisterCallBack) {
        Map<String, String> map = new HashMap();
        map.put( "phone", userName );
        map.put( "pwd", password );

        OkHttpPost.EnestenPost( HttpUrlUtil.REGISTER_URL, map, new OkhttpCallBack( new HttpDataListener() {
            @Override
            public void httpSuccess(String httpSuccess) {
                Gson gson = new Gson();
                LoginBean loginBean = gson.fromJson( httpSuccess, LoginBean.class );
                String message = loginBean.getMessage();
                String status = loginBean.getStatus();
                if (status.equals( "0000" )) {
                    RegisterCallBack.registerSuccess( message );
                } else {
                    RegisterCallBack.onFail( message );
                }
            }

            @Override
            public void httpfail(String httpfail) {
                RegisterCallBack.onFail( httpfail );
            }
        } ) );
    }
}
