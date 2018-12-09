package com.bwei.model.fangweidushangcheng.Util;

/**
 * date:2018/12/5
 * author:郝仁（Thinkpad)
 * function:
 */
public class HttpUrlUtil {

    public static String BASE_URL = "http://172.17.8.100/small";
     //登录
    public static String LOGIN_URL = BASE_URL + "/user/v1/login";
    //注册
    public static String REGISTER_URL = BASE_URL + "/user/v1/register";
    //轮播图
    public static String BANNER_URL = BASE_URL + "/commodity/v1/bannerShow";
    //home请求数据
    public static String HOME_URL = BASE_URL + "/commodity/v1/commodityList";


}
