package com.bwei.model.fangweidushangcheng.mvp;

import com.bwei.model.fangweidushangcheng.callback.HttpCallBack;
import com.bwei.model.fangweidushangcheng.mvp.model.LoginModel;
import com.bwei.model.fangweidushangcheng.mvp.model.RegisterModel;
import com.bwei.model.fangweidushangcheng.mvp.view.OnView;

/**
 * date:2018/12/1
 * author:郝仁（Thinkpad)
 * function:
 */
public class OnPresenter {

    private LoginModel mLoginModel;
    private RegisterModel mRegisterModel;
    private OnView mLoginView;

    public OnPresenter(OnView loginView) {
        mLoginView = loginView;
        mLoginModel = new LoginModel();
        mRegisterModel = new RegisterModel();
    }

    public void login(String userName, String password) {
        mLoginModel.login(userName, password, new HttpCallBack() {

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
        mRegisterModel.register(userName, password, new HttpCallBack() {
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
