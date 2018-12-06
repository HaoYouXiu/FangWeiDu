package com.bwei.model.fangweidushangcheng.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * date:2018/12/5
 * author:郝仁（Thinkpad)
 * function: ViewPager禁止滑动
 */
public class NoScrollViewPager extends ViewPager {

    private boolean isScroll = false;

    public NoScrollViewPager(@NonNull Context context) {
        super( context );
    }

    public NoScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super( context, attrs );
    }

    /**
     * 设置页面是否能滑动
     */
    public void setScroll(boolean scroll) {
        isScroll = scroll;
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        return isScroll && super.onInterceptHoverEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isScroll && super.onTouchEvent( ev );
    }
}
