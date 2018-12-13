package com.bwei.model.fangweidushangcheng.fragment.homefragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.model.fangweidushangcheng.Adapter.homeadapter.HomeHotpreAdapter;
import com.bwei.model.fangweidushangcheng.R;
import com.bwei.model.fangweidushangcheng.Util.ToasUtil;
import com.bwei.model.fangweidushangcheng.bean.BannerBean;
import com.bwei.model.fangweidushangcheng.bean.HomeBean;
import com.bwei.model.fangweidushangcheng.mvp.callback.CiricleCallBack;
import com.bwei.model.fangweidushangcheng.mvp.presenter.Ciriclepresenter;
import com.bwei.model.fangweidushangcheng.mvp.presenter.HomePresenter;
import com.bwei.model.fangweidushangcheng.mvp.view.CiricleView;
import com.bwei.model.fangweidushangcheng.mvp.view.HomeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * date:2018/12/13
 * author:郝仁（Thinkpad)
 * function:
 */
public class HomeHotpreFragment extends Fragment implements HomeView{

    @BindView(R.id.hotproducts_image)
    ImageView hotproductsImage;
    @BindView(R.id.hotproducts_searchbox)
    EditText hotproductsSearchbox;
    @BindView(R.id.hotproducts_seek)
    TextView hotproductsSeek;
    @BindView(R.id.hotproducts_recycler)
    RecyclerView hotproductsRecycler;
    Unbinder unbinder;
    private HomeHotpreAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_home_hotpreoducts, container, false );
        unbinder = ButterKnife.bind( this, view );
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );

        //流失布局
        GridLayoutManager manager = new GridLayoutManager( getContext(),2 );
        hotproductsRecycler.setLayoutManager( manager );

        HomePresenter presenter = new HomePresenter( this );
        presenter.homehotpre(1002, 1, 5);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.hotproducts_image, R.id.hotproducts_searchbox, R.id.hotproducts_seek, R.id.hotproducts_recycler})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hotproducts_image:
                break;
            case R.id.hotproducts_searchbox:
                break;
            case R.id.hotproducts_seek:
                break;
            case R.id.hotproducts_recycler:
                break;
        }
    }


    @Override
    public void HomeSuccess(List<BannerBean.ResultBean> success) {

    }

    @Override
    public void RcHomeSuccess(HomeBean.ResultBean commodityList) {

    }

    @Override
    public void HomeHotpreSuccess(List success) {
        if (mAdapter == null){
            mAdapter = new HomeHotpreAdapter( getContext(),success );
            hotproductsRecycler.setAdapter( mAdapter );
        }
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void HomeFail(String fail) {
        ToasUtil.showToas( fail );
    }
}
