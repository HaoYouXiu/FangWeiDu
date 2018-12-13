package com.bwei.model.fangweidushangcheng.fragment.event;

import android.support.v4.app.Fragment;

/**
 * date:2018/12/13
 * author:郝仁（Thinkpad)
 * function:
 */
public class DismssEvent {
    private Fragment mNeedDismiss;

    public DismssEvent(Fragment needDismiss) {
        mNeedDismiss = needDismiss;
    }

    public Fragment getNeedDismiss() {
        return mNeedDismiss;
    }
}
