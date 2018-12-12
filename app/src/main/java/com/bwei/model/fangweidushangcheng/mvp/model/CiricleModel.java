package com.bwei.model.fangweidushangcheng.mvp.model;

import com.bwei.model.fangweidushangcheng.Util.Util;
import com.bwei.model.fangweidushangcheng.bean.CircleBean;
import com.bwei.model.fangweidushangcheng.mvp.callback.CiricleCallBack;
import com.bwei.model.fangweidushangcheng.net.RetrefitUtil;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2018/12/11
 * author:郝仁（Thinkpad)
 * function:
 */
public class CiricleModel {
    public void ciricle(String s, String s1, final CiricleCallBack ciricleCallBack) {
        Util create = RetrefitUtil.getInstance().Create( Util.class );
        create.getUser( s, s1 )
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Consumer<CircleBean>() {
                    @Override
                    public void accept(CircleBean circleBean) throws Exception {
                        List<CircleBean.ResultBean> result = circleBean.getResult();
                        ciricleCallBack.cririSuccess(result);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                     ciricleCallBack.cririFail( "失败" );
                    }
                } );
    }
}
