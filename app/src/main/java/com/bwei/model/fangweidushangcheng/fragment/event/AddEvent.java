package com.bwei.model.fangweidushangcheng.fragment.event;

import android.support.v4.app.Fragment;

/**
 * date:2018/12/13
 * author:郝仁（Thinkpad)
 * function:
 */
 public class AddEvent {
     private Fragment needAdd;

    public AddEvent(Fragment needAdd) {
        this.needAdd = needAdd;
    }

    public Fragment getNeedAdd() {
        return needAdd;
    }
}
