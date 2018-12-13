package com.bwei.model.fangweidushangcheng;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwei.model.fangweidushangcheng.Adapter.NoScrollViewPager;
import com.bwei.model.fangweidushangcheng.fragment.CircleFragment;
import com.bwei.model.fangweidushangcheng.fragment.HomeFragment;
import com.bwei.model.fangweidushangcheng.fragment.ListFragment;
import com.bwei.model.fangweidushangcheng.fragment.MyFragment;
import com.bwei.model.fangweidushangcheng.fragment.ShoppingcartFragment;
import com.bwei.model.fangweidushangcheng.fragment.event.AddEvent;
import com.bwei.model.fangweidushangcheng.fragment.event.DismssEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fragment_Layout)
    FrameLayout fragmentLayout;
    private ArrayList<Fragment> mFragmentList;

    @BindView(R.id.view_pager)
    NoScrollViewPager viewPager;
    @BindView(R.id.fragment_home)
    RadioButton fragmentHome;
    @BindView(R.id.fragment_circle)
    RadioButton fragmentCircle;
    @BindView(R.id.fragment_shoppingcart)
    RadioButton fragmentShoppingcart;
    @BindView(R.id.fragment_list)
    RadioButton fragmentList;
    @BindView(R.id.fragment_my)
    RadioButton fragmentMy;
    @BindView(R.id.radio)
    RadioGroup radio;

    private List<Fragment> mList = new ArrayList<>();
    private FragmentManager mFragmentManager;
    private Fragment curfragment;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ButterKnife.bind( this );

        EventBus.getDefault().register( this );
        //控制滑动
        viewPager.setScroll( false );

        mFragmentList = new ArrayList<Fragment>();
        mFragmentList.add( new HomeFragment() );
        mFragmentList.add( new CircleFragment() );
        mFragmentList.add( new ShoppingcartFragment() );
        mFragmentList.add( new ListFragment() );
        mFragmentList.add( new MyFragment() );

        mFragmentManager = getSupportFragmentManager();
        viewPager.setAdapter( new FragmentPagerAdapter( getSupportFragmentManager() ) {
            @Override
            public Fragment getItem(int i) {
                return mFragmentList.get( i );
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        } );

        viewPager.addOnPageChangeListener( new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                cleartAll(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        } );

    }

    private void cleartAll(int i) {
        for (int j = 0; j < mList.size(); j++) {
            mFragmentManager.popBackStack();
        }

        mList.clear();
        curfragment = null;
        viewPager.setVisibility(View.VISIBLE);
        viewPager.setCurrentItem( i );
    }

    //用于添加方法
    @Subscribe
    public void eventAdd(AddEvent event){
        if (viewPager.getVisibility() != View.GONE){
            viewPager.setVisibility( View.GONE );
        }

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (curfragment != null){
            transaction.hide( curfragment );
        }
        curfragment = event.getNeedAdd();
        mList.add( curfragment );
        transaction.add( R.id.fragment_Layout, curfragment );
        transaction.addToBackStack(null);
        transaction.commit();
    }
    //删除
    @Subscribe
    public void evenDismiss(DismssEvent dismssEvent){
        Fragment needDismiss = dismssEvent.getNeedDismiss();
        mList.remove( needDismiss );
        curfragment = null;

        if (mList.size() > 0){
            curfragment = mList.get( mList.size()-1 );
        }else if (viewPager.getVisibility() != View.VISIBLE){
            viewPager.setVisibility( View.VISIBLE );
        }
        mFragmentManager.popBackStack();
    }

    private void clear(int position){
        for (int i = 0; i <mList.size() ; i++) {
            mFragmentManager.popBackStack();
        }
        viewPager = null;
        mFragmentList.clear();
        viewPager.setVisibility( View.VISIBLE );
        viewPager.setCurrentItem( position );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mList.remove( curfragment );
        curfragment = null;
        if (mList.size()>0){
            curfragment = mList.get( mList.size()-1 );
        } else if (viewPager.getVisibility() != View.VISIBLE) {
            viewPager.setVisibility( View.VISIBLE );
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.view_pager, R.id.fragment_home, R.id.fragment_circle, R.id.fragment_shoppingcart, R.id.fragment_list, R.id.fragment_my, R.id.radio})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.view_pager:

                break;
            case R.id.fragment_home:
                viewPager.setCurrentItem( 0 );
                break;
            case R.id.fragment_circle:
                viewPager.setCurrentItem( 1 );
                break;
            case R.id.fragment_shoppingcart:
                viewPager.setCurrentItem( 2 );
                break;
            case R.id.fragment_list:
                viewPager.setCurrentItem( 3 );
                break;
            case R.id.fragment_my:
                viewPager.setCurrentItem( 4 );
                break;
            case R.id.radio:
                radio.check( R.id.fragment_home );
                break;
        }
    }

    @OnClick(R.id.fragment_Layout)
    public void onViewClicked() {
    }
}
