package com.bwei.model.fangweidushangcheng.Util;

import com.bwei.model.fangweidushangcheng.bean.CircleBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * date:2018/12/11
 * author:郝仁（Thinkpad)
 * function:
 */
public interface Util {
    @GET("circle/v1/findCircleList")
    Observable<CircleBean> getUser(@Query( "page") String page, @Query( "count" ) String count);
}
