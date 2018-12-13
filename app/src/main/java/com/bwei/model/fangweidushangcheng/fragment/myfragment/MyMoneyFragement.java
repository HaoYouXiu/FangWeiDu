package com.bwei.model.fangweidushangcheng.fragment.myfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.model.fangweidushangcheng.R;

/**
 * date:2018/12/11
 * author:郝仁（Thinkpad)
 * function:
 */
public class MyMoneyFragement extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.my_money, container, false );

        return view;
    }

}
