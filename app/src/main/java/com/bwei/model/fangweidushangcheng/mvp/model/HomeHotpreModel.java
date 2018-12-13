package com.bwei.model.fangweidushangcheng.mvp.model;

import com.bwei.model.fangweidushangcheng.Util.Util;
import com.bwei.model.fangweidushangcheng.bean.CircleBean;
import com.bwei.model.fangweidushangcheng.bean.HomeHotpreBean;
import com.bwei.model.fangweidushangcheng.mvp.callback.CiricleCallBack;
import com.bwei.model.fangweidushangcheng.mvp.callback.HomeCallBack;
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
public class HomeHotpreModel {

    public void homehotpre(int i, int i1, int i2, final HomeCallBack homeCallBack) {
        Util create = RetrefitUtil.getInstance().Create( Util.class );
        create.getCiriclehotpre( i, i1, i2 )
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Consumer<HomeHotpreBean>() {
                    @Override
                    public void accept(HomeHotpreBean homeHotpreBean) throws Exception {
                        List<HomeHotpreBean.ResultBean> result = homeHotpreBean.getResult();
                        homeCallBack.HomeHotpreSuccess( result );
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        homeCallBack.HomeFail( "失败" );
                    }
                } );
    }
}
