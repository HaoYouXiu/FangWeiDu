package com.bwei.model.fangweidushangcheng.mvp.presenter;

import com.bwei.model.fangweidushangcheng.bean.BannerBean;
import com.bwei.model.fangweidushangcheng.bean.HomeBean;
import com.bwei.model.fangweidushangcheng.mvp.callback.HomeCallBack;
import com.bwei.model.fangweidushangcheng.mvp.callback.LoginCallBack;
import com.bwei.model.fangweidushangcheng.mvp.model.HomeHotpreModel;
import com.bwei.model.fangweidushangcheng.mvp.model.HomeModel;
import com.bwei.model.fangweidushangcheng.mvp.model.LoginModel;
import com.bwei.model.fangweidushangcheng.mvp.model.RcHomeModel;
import com.bwei.model.fangweidushangcheng.mvp.model.RegisterModel;
import com.bwei.model.fangweidushangcheng.mvp.view.HomeView;
import com.bwei.model.fangweidushangcheng.mvp.view.LoginView;

import java.util.List;

/**
 * date:2018/12/1
 * author:郝仁（Thinkpad)
 * function:
 */
public class HomePresenter {

    private HomeModel mHomeModel;
    private RcHomeModel mRcHomeModel;
    private HomeView mLoginView;
    private HomeHotpreModel mHomeHotpreModel;

    public HomePresenter(HomeView loginView) {
        mLoginView = loginView;
        mHomeModel = new HomeModel();
        mRcHomeModel = new RcHomeModel();
        mHomeHotpreModel = new HomeHotpreModel();
    }


    public void banner() {
        mHomeModel.banner( new HomeCallBack() {
            @Override
            public void HomeSuccess(List<BannerBean.ResultBean> success) {
                mLoginView.HomeSuccess(success);
            }

            @Override
            public void RcHomeSuccess(HomeBean.ResultBean commodityList) {

            }

            @Override
            public void HomeHotpreSuccess(List success) {

            }


            @Override
            public void HomeFail(String fail) {
                 mLoginView.HomeFail(fail);
            }
        } );
    }

    public void home() {
        mRcHomeModel.home( new HomeCallBack() {
            @Override
            public void HomeSuccess(List<BannerBean.ResultBean> success) {

            }

            @Override
            public void RcHomeSuccess(HomeBean.ResultBean commodityList) {
                  mLoginView.RcHomeSuccess( commodityList );
            }

            @Override
            public void HomeHotpreSuccess(List success) {

            }


            @Override
            public void HomeFail(String fail)  {
                mLoginView.HomeFail( fail );
            }
        } );
    }

    public void homehotpre(int i, int i1, int i2) {
        mHomeHotpreModel.homehotpre(i, i1, i2, new HomeCallBack() {
            @Override
            public void HomeSuccess(List<BannerBean.ResultBean> success) {

            }

            @Override
            public void RcHomeSuccess(HomeBean.ResultBean commodityList) {

            }

            @Override
            public void HomeHotpreSuccess(List success) {
                  mLoginView.HomeHotpreSuccess( success );
            }

            @Override
            public void HomeFail(String fail) {
                mLoginView.HomeFail( fail );
            }
        } );
    }
}
