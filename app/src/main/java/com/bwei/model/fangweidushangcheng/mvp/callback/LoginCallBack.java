package com.bwei.model.fangweidushangcheng.mvp.callback;

/**
 * date:2018/12/1
 * author:郝仁（Thinkpad)
 * function:
 */
public interface LoginCallBack {

    void LoginSuccess(String success);
    void registerSuccess(String registersuccess);
    void onFail(String fail);
}
