package com.bwei.model.fangweidushangcheng.fragment.homefragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.model.fangweidushangcheng.R;

import butterknife.ButterKnife;

/**
 * date:2018/12/13
 * author:郝仁（Thinkpad)
 * function:
 */
public class HomeFashionFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_home_fashion, container, false );
        return view;
    }
}
