package com.bwei.model.fangweidushangcheng.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public class MyUserFragement extends Fragment {

    @BindView(R.id.nq_image)
    ImageView nqImage;
    @BindView(R.id.nq_name)
    TextView nqName;
    @BindView(R.id.nq_price)
    TextView nqPrice;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.my_user, container, false );

        unbinder = ButterKnife.bind( this, view );
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.nq_image, R.id.nq_name, R.id.nq_price})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.nq_image:
                break;
            case R.id.nq_name:
                break;
            case R.id.nq_price:
                break;
        }
    }
}
