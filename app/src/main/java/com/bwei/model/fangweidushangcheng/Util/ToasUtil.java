package com.bwei.model.fangweidushangcheng.Util;

import android.widget.Toast;

import com.bwei.model.fangweidushangcheng.app.App;

/**
 * date:2018/12/5
 * author:郝仁（Thinkpad)
 * function:
 */
public class ToasUtil {

    public static void showToas(String msg){
         Toast.makeText( App.scontext, msg, Toast.LENGTH_SHORT).show();
    }
}
