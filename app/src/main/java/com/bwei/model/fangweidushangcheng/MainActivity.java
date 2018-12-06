package com.bwei.model.fangweidushangcheng;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwei.model.fangweidushangcheng.Adapter.NoScrollViewPager;
import com.bwei.model.fangweidushangcheng.fragment.CircleFragment;
import com.bwei.model.fangweidushangcheng.fragment.HomeFragment;
import com.bwei.model.fangweidushangcheng.fragment.ListFragment;
import com.bwei.model.fangweidushangcheng.fragment.MyFragment;
import com.bwei.model.fangweidushangcheng.fragment.ShoppingcartFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

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

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewPager.setScroll(false);

        mFragmentList = new ArrayList<Fragment>();
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new CircleFragment());
        mFragmentList.add(new ShoppingcartFragment());
        mFragmentList.add(new ListFragment());
        mFragmentList.add(new MyFragment());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFragmentList.get(i);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });

    }


    @OnClick({R.id.view_pager, R.id.fragment_home, R.id.fragment_circle, R.id.fragment_shoppingcart, R.id.fragment_list, R.id.fragment_my, R.id.radio})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.view_pager:

                break;
            case R.id.fragment_home:
                viewPager.setCurrentItem(0);
                break;
            case R.id.fragment_circle:
                viewPager.setCurrentItem(1);
                break;
            case R.id.fragment_shoppingcart:
                viewPager.setCurrentItem(2);
                break;
            case R.id.fragment_list:
                viewPager.setCurrentItem(3);
                break;
            case R.id.fragment_my:
                viewPager.setCurrentItem(4);
                break;
            case R.id.radio:
                radio.check(R.id.fragment_home);
                break;
        }
    }
}
