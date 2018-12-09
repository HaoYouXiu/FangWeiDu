package com.bwei.model.fangweidushangcheng.mvp.view;

import com.bwei.model.fangweidushangcheng.bean.LoginBean;

import java.util.List;

/**
 * date:2018/12/1
 * author:郝仁（Thinkpad)
 * function:
 */
public interface LoginView {
    void LoginSuccess(String success);
    void registerSuccess(String registersuccess);
    void onFail(String fail);

}
