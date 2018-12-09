package com.bwei.model.fangweidushangcheng.mvp.model;


import android.os.Handler;
import android.os.Message;

import com.bwei.model.fangweidushangcheng.Util.HttpUrlUtil;
import com.bwei.model.fangweidushangcheng.bean.BannerBean;
import com.bwei.model.fangweidushangcheng.mvp.callback.HomeCallBack;
import com.bwei.model.fangweidushangcheng.net.HttpDataListener;
import com.bwei.model.fangweidushangcheng.net.OkHttpPost;
import com.bwei.model.fangweidushangcheng.net.OkhttpCallBack;
import com.google.gson.Gson;

import java.util.List;


/**
 * date:2018/12/1
 * author:郝仁（Thinkpad)
 * function:
 */
public class HomeModel {

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage( msg );
        }
    };

    public void banner(final HomeCallBack homeCallBack) {
//        OkHttpPost.EnestenGet( HttpUrlUtil.BANNER_URL, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                homeCallBack.HomeFail("失败！！！");
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String s = response.body().string();
//                Gson gson = new Gson();
//                final BannerBean bannerBean = gson.fromJson(s, BannerBean.class );
//                mHandler.post( new Runnable() {
//                    @Override
//                    public void run() {
//                        List<BannerBean.ResultBean> result = bannerBean.getResult();
//                        homeCallBack.HomeSuccess( result );
//                    }
//                } );
//            }
//        } );
        OkHttpPost.EnestenGet(HttpUrlUtil.BANNER_URL, new OkhttpCallBack(new HttpDataListener() {
            @Override
            public void httpSuccess(String httpSuccess) {
                Gson gson = new Gson();
                final BannerBean bannerBean = gson.fromJson( httpSuccess, BannerBean.class );
                mHandler.post( new Runnable() {
                    @Override
                    public void run() {
                        List<BannerBean.ResultBean> result = bannerBean.getResult();
                        homeCallBack.HomeSuccess( result );
                    }
                } );
            }

            @Override
            public void httpfail(final String httpfail) {
                mHandler.post( new Runnable() {
                    @Override
                    public void run() {
                        homeCallBack.HomeFail(httpfail);
                    }
                } );

            }
        }));
    }

}
