package com.bwei.model.fangweidushangcheng.mvp.view;

import com.bwei.model.fangweidushangcheng.bean.CircleBean;

import java.util.List;

/**
 * date:2018/12/11
 * author:郝仁（Thinkpad)
 * function:
 */
public interface CiricleView {
    void cririSuccess(List<CircleBean.ResultBean> success);
    void cririFail(String fail);
}
