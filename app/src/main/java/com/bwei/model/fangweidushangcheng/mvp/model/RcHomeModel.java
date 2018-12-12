package com.bwei.model.fangweidushangcheng.mvp.model;
import android.os.Handler;
import android.os.Message;

import com.bwei.model.fangweidushangcheng.Util.HttpUrlUtil;
import com.bwei.model.fangweidushangcheng.bean.HomeBean;
import com.bwei.model.fangweidushangcheng.mvp.callback.HomeCallBack;
import com.bwei.model.fangweidushangcheng.net.HttpDataListener;
import com.bwei.model.fangweidushangcheng.net.OkHttpPost;
import com.bwei.model.fangweidushangcheng.net.OkhttpCallBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * date:2018/12/7
 * author:郝仁（Thinkpad)
 * function:
 */
public class RcHomeModel {

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage( msg );
        }
    };

    public void home(final HomeCallBack homeCallBack) {
        OkHttpPost.enqueueGet(HttpUrlUtil.HOME_URL, null, new OkhttpCallBack( new HttpDataListener() {
            @Override
            public void httpSuccess(String httpSuccess) {
                Gson gson = new Gson();
                final HomeBean homeBean = gson.fromJson( httpSuccess, HomeBean.class );
                mHandler.post( new Runnable() {
                    @Override
                    public void run() {
                        HomeBean.ResultBean commodityList = homeBean.getResult();
                        homeCallBack.RcHomeSuccess( commodityList );
                    }
                } );

            }

            @Override
            public void httpfail(String httpfail) {
                homeCallBack.HomeFail( httpfail );
            }
        } ) );
    }
}
