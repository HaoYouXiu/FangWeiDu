package com.bwei.model.fangweidushangcheng.mvp.callback;

import com.bwei.model.fangweidushangcheng.bean.BannerBean;
import com.bwei.model.fangweidushangcheng.bean.HomeBean;

import java.util.List;

/**
 * date:2018/12/1
 * author:郝仁（Thinkpad)
 * function:
 */
public interface HomeCallBack {

    void HomeSuccess(List<BannerBean.ResultBean> success);
    void RcHomeSuccess(HomeBean.ResultBean commodityList);
    void HomeFail(String fail);
}
