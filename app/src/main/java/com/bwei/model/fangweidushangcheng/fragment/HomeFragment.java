package com.bwei.model.fangweidushangcheng.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.model.fangweidushangcheng.Adapter.BannerRecyclerAdapter;
import com.bwei.model.fangweidushangcheng.Adapter.CyNewqualityAdapter;
import com.bwei.model.fangweidushangcheng.Adapter.FashionRcyclerAdapter;
import com.bwei.model.fangweidushangcheng.Adapter.LifeRcyclerAdapter;
import com.bwei.model.fangweidushangcheng.Adapter.NewQualityAdapter;
import com.bwei.model.fangweidushangcheng.R;
import com.bwei.model.fangweidushangcheng.bean.BannerBean;
import com.bwei.model.fangweidushangcheng.bean.HomeBean;
import com.bwei.model.fangweidushangcheng.fragment.event.AddEvent;
import com.bwei.model.fangweidushangcheng.fragment.homefragment.HomeFashionFragment;
import com.bwei.model.fangweidushangcheng.fragment.homefragment.HomeHotpreFragment;
import com.bwei.model.fangweidushangcheng.fragment.homefragment.HomeLifeFragement;
import com.bwei.model.fangweidushangcheng.fragment.myfragment.MyUserFragement;
import com.bwei.model.fangweidushangcheng.mvp.presenter.HomePresenter;
import com.bwei.model.fangweidushangcheng.mvp.view.HomeView;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * date:2018/12/4
 * author:郝仁（Thinkpad)
 * function:
 */
public class HomeFragment extends Fragment implements HomeView {
    private static final String TAG = "HomeFragment";

    @BindView(R.id.home_head_image)
    ImageView homeHeadImage;
    @BindView(R.id.home_head_searchbox)
    EditText homeHeadSearchbox;
    @BindView(R.id.home_head_seek)
    TextView homeHeadSeek;
    @BindView(R.id.fragment_hotproducts)
    ImageView fragmentHotproducts;
    @BindView(R.id.fragment_fashion)
    ImageView fragmentFashion;
    @BindView(R.id.fragment_cy_sashion)
    RecyclerView fragmentCySashion;
    @BindView(R.id.fragment_Life)
    ImageView fragmentLife;
    @BindView(R.id.fragment_cy_Life)
    RecyclerView fragmentCyLife;
    Unbinder unbinder;
    private MZBannerView homeCarousel;
    private HomePresenter mHomePresenter;
    private RecyclerView fragmentCyNewquality;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_home, container, false );
        //轮播图控件
        homeCarousel = (MZBannerView) view.findViewById( R.id.home_carousel );
        fragmentCyNewquality = (RecyclerView) view.findViewById( R.id.fragment_cy_newquality );

        unbinder = ButterKnife.bind( this, view );
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        //新品布局
        LinearLayoutManager manager = new LinearLayoutManager( getContext() );
        manager.setOrientation( LinearLayoutManager.HORIZONTAL);
        fragmentCyNewquality.setLayoutManager( manager );
        //魔力时尚
        LinearLayoutManager manager1 = new LinearLayoutManager( getContext() );
        manager1.setOrientation( LinearLayoutManager.VERTICAL);
        fragmentCySashion.setLayoutManager( manager1 );
        //品质生活
        GridLayoutManager manager2 = new GridLayoutManager( getContext(),2 );
        fragmentCyLife.setLayoutManager( manager2 );

        //层
        mHomePresenter = new HomePresenter( this );
        mHomePresenter.banner();
        mHomePresenter.home();


    }


    @Override
    public void HomeSuccess(final List<BannerBean.ResultBean> success) {
        //轮播图
        homeCarousel.setPages( success, new MZHolderCreator<BannerRecyclerAdapter>() {
            @Override
            public BannerRecyclerAdapter createViewHolder() {
                return new BannerRecyclerAdapter( success, getActivity() );
            }
        } );

    }

    @Override
    public void RcHomeSuccess(HomeBean.ResultBean commodityList) {
        //新品
        NewQualityAdapter adapter = new NewQualityAdapter( getContext(), commodityList );
        fragmentCyNewquality.setAdapter(adapter);
        //魔力时尚
        FashionRcyclerAdapter fashionAdapter = new FashionRcyclerAdapter( getContext(),commodityList );
        fragmentCySashion.setAdapter( fashionAdapter );
        //品质生活
        LifeRcyclerAdapter liftAdapter = new LifeRcyclerAdapter( getContext(),commodityList );
        fragmentCyLife.setAdapter( liftAdapter );
    }

    @Override
    public void HomeHotpreSuccess(List success) {

    }


    @Override
    public void HomeFail(String fail) {
        Toast.makeText( getContext(), fail, Toast.LENGTH_SHORT ).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.home_head_image, R.id.home_head_searchbox, R.id.home_head_seek, R.id.fragment_hotproducts, R.id.fragment_fashion, R.id.fragment_cy_sashion, R.id.fragment_Life, R.id.fragment_cy_Life})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_head_image:
                break;
            case R.id.home_head_searchbox:
                break;
            case R.id.home_head_seek:
                break;
            case R.id.fragment_hotproducts:
                EventBus.getDefault().post( new AddEvent( new HomeHotpreFragment() ) );
                break;
            case R.id.fragment_fashion:
                EventBus.getDefault().post( new AddEvent( new HomeHotpreFragment() ) );
                break;
            case R.id.fragment_cy_sashion:
                break;
            case R.id.fragment_Life:
                EventBus.getDefault().post( new AddEvent( new HomeHotpreFragment()) );
                break;
            case R.id.fragment_cy_Life:
                break;
        }
    }
}
