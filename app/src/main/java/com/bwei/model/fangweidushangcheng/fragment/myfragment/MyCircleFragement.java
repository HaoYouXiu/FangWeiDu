package com.bwei.model.fangweidushangcheng.fragment.myfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
public class MyCircleFragement extends Fragment {

    @BindView(R.id.circle_delete)
    ImageView circleDelete;
    @BindView(R.id.circle_recycler)
    RecyclerView circleRecycler;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.my_circle, container, false );

        unbinder = ButterKnife.bind( this, view );
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.circle_delete, R.id.circle_recycler})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.circle_delete:
                break;
            case R.id.circle_recycler:
                break;
        }
    }
}
