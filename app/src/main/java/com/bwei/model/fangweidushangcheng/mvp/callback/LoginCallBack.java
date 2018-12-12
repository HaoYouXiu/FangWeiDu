package com.bwei.model.fangweidushangcheng.mvp.callback;

import com.bwei.model.fangweidushangcheng.bean.LoginBean;

/**
 * date:2018/12/1
 * author:郝仁（Thinkpad)
 * function:
 */
public interface LoginCallBack {

    void LoginSuccess(LoginBean success);
    void registerSuccess(String registersuccess);
    void onFail(String fail);
}
