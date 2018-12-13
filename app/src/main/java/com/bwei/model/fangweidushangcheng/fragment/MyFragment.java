package com.bwei.model.fangweidushangcheng.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bwei.model.fangweidushangcheng.R;
import com.bwei.model.fangweidushangcheng.fragment.event.AddEvent;
import com.bwei.model.fangweidushangcheng.fragment.myfragment.MyAddresFragement;
import com.bwei.model.fangweidushangcheng.fragment.myfragment.MyCircleFragement;
import com.bwei.model.fangweidushangcheng.fragment.myfragment.MyFootFragement;
import com.bwei.model.fangweidushangcheng.fragment.myfragment.MyMoneyFragement;
import com.bwei.model.fangweidushangcheng.fragment.myfragment.MyUserFragement;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * date:2018/12/4
 * author:郝仁（Thinkpad)
 * function:
 */
public class MyFragment extends Fragment {

    @BindView(R.id.my_icon)
    SimpleDraweeView myIcon;
    Unbinder unbinder;
    @BindView(R.id.my_personaldata)
    RelativeLayout myPersonaldata;
    @BindView(R.id.my_mcircle)
    RelativeLayout myMcircle;
    @BindView(R.id.my_mfoot)
    RelativeLayout myMfoot;
    @BindView(R.id.my_money)
    RelativeLayout myMoney;
    @BindView(R.id.my_maddres)
    RelativeLayout myMaddres;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_my, container, false );

        unbinder = ButterKnife.bind( this, view );

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        Uri uri = Uri.parse( "res:///" + R.mipmap.my_iconcopy );
        myIcon.setImageURI( uri );

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.my_icon)
    public void onViewClicked() {

    }

    @OnClick({R.id.my_personaldata, R.id.my_mcircle, R.id.my_mfoot, R.id.my_money, R.id.my_maddres})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_personaldata:
                  //新建fragment
                EventBus.getDefault().post( new AddEvent( new MyUserFragement() ) );
                break;
            case R.id.my_mcircle:
                EventBus.getDefault().post( new AddEvent( new MyCircleFragement()) );
                break;
            case R.id.my_mfoot:
                EventBus.getDefault().post( new AddEvent( new MyFootFragement()) );
                break;
            case R.id.my_money:
                EventBus.getDefault().post( new AddEvent( new MyMoneyFragement()) );
                break;
            case R.id.my_maddres:
                EventBus.getDefault().post( new AddEvent( new MyAddresFragement()) );
                break;
        }
    }
}
