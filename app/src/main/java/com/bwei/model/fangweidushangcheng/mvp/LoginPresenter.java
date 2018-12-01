package com.bwei.model.fangweidushangcheng.mvp;

import com.bwei.model.fangweidushangcheng.mvp.view.LoginView;

/**
 * date:2018/12/1
 * author:郝仁（Thinkpad)
 * function:
 */
public class LoginPresenter {

    private LoginModel mLoginModel;
    private LoginView mLoginView;

    public LoginPresenter(LoginView loginView) {
        mLoginView = loginView;
        mLoginModel = new LoginModel();
    }
}
