package com.bwei.model.fangweidushangcheng.mvp.presenter;

import com.bwei.model.fangweidushangcheng.bean.CircleBean;
import com.bwei.model.fangweidushangcheng.mvp.callback.CiricleCallBack;
import com.bwei.model.fangweidushangcheng.mvp.model.CiricleModel;
import com.bwei.model.fangweidushangcheng.mvp.view.CiricleView;

import java.util.List;

/**
 * date:2018/12/11
 * author:郝仁（Thinkpad)
 * function:
 */
public class Ciriclepresenter {
    private CiricleModel mCiricleModel;
    private CiricleView mCiricleView;

    public Ciriclepresenter(CiricleView ciricleView) {
        mCiricleView = ciricleView;
        mCiricleModel = new CiricleModel();
    }

    public void ciricle(final String s, String s1) {
        mCiricleModel.ciricle(s, s1, new CiricleCallBack() {
            @Override
            public void cririSuccess(List success) {
                mCiricleView.cririSuccess( success );
            }

            @Override
            public void cririFail(String fail) {
                mCiricleView.cririFail(fail);
            }
        } );
    }
}
