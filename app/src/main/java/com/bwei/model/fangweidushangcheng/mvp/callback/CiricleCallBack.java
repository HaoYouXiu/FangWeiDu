package com.bwei.model.fangweidushangcheng.mvp.callback;

import com.bwei.model.fangweidushangcheng.bean.CircleBean;

import java.util.List;

/**
 * date:2018/12/11
 * author:郝仁（Thinkpad)
 * function:
 */
public interface CiricleCallBack {
    void cririSuccess(List success);
    void cririFail(String fail);
}
