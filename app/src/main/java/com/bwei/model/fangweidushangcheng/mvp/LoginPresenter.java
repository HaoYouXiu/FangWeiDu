package com.bwei.model.fangweidushangcheng.mvp;

import com.bwei.model.fangweidushangcheng.mvp.callback.LoginCallBack;
import com.bwei.model.fangweidushangcheng.mvp.model.LoginModel;
import com.bwei.model.fangweidushangcheng.mvp.model.RegisterModel;
import com.bwei.model.fangweidushangcheng.mvp.view.LoginView;

/**
 * date:2018/12/1
 * author:郝仁（Thinkpad)
 * function:
 */
public class LoginPresenter {

    private LoginModel mLoginModel;
    private RegisterModel mRegisterModel;
    private LoginView mLoginView;

    public LoginPresenter(LoginView loginView) {
        mLoginView = loginView;
        mLoginModel = new LoginModel();
        mRegisterModel = new RegisterModel();
    }

    public void login(String userName, String password) {
        mLoginModel.login(userName, password, new LoginCallBack() {

            @Override
            public void LoginSuccess(String success) {
                mLoginView.LoginSuccess( success );
            }

            @Override
            public void registerSuccess(String registersuccess) {

            }

            @Override
            public void onFail(String fail) {
                mLoginView.onFail(fail);
            }
        });
    }

    public void register(String userName, String password) {
        mRegisterModel.register(userName, password, new LoginCallBack() {
            @Override
            public void LoginSuccess(String success) {

            }

            @Override
            public void registerSuccess(String registersuccess) {
               mLoginView.registerSuccess(registersuccess);
            }


            @Override
            public void onFail(String fail) {
                mLoginView.onFail(fail);
            }
        });
    }
}
