package com.bwei.model.fangweidushangcheng.fragment.myfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.bwei.model.fangweidushangcheng.R;
import com.facebook.drawee.view.SimpleDraweeView;

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

    @BindView(R.id.user_tou)
    TextView userTou;
    @BindView(R.id.user_image)
    SimpleDraweeView userImage;
    @BindView(R.id.user_pass)
    TextView userPass;
    @BindView(R.id.user_passwrod)
    EditText userPasswrod;
    @BindView(R.id.user_ming)
    TextView userMing;
    @BindView(R.id.user_name)
    EditText userName;
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

    @OnClick({R.id.user_tou, R.id.user_image, R.id.user_pass, R.id.user_passwrod, R.id.user_ming, R.id.user_name})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_tou:
                break;
            case R.id.user_image:
                break;
            case R.id.user_pass:
                break;
            case R.id.user_passwrod:
                break;
            case R.id.user_ming:
                break;
            case R.id.user_name:
                break;
        }
    }
}
