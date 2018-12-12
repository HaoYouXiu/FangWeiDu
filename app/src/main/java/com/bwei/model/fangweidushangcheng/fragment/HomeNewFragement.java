package com.bwei.model.fangweidushangcheng.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwei.model.fangweidushangcheng.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * date:2018/12/11
 * author:郝仁（Thinkpad)
 * function:
 */
public class HomeNewFragement extends Fragment {

    @BindView(R.id.add)
    TextView add;
    @BindView(R.id.delete)
    TextView delete;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_home_new, container, false );
        unbinder = ButterKnife.bind( this, view );
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.add, R.id.delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add:
                break;
            case R.id.delete:
                break;
        }
    }
}
