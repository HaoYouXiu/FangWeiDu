package com.bwei.model.fangweidushangcheng.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;
import com.bwei.model.fangweidushangcheng.R;
import com.bwei.model.fangweidushangcheng.bean.BannerBean;
import com.bwei.model.fangweidushangcheng.fragment.HomeFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.List;

import recycler.coverflow.RecyclerCoverFlow;

/**
 * date:2018/12/6
 * author:郝仁（Thinkpad)
 * function:
 */
public class BannerRecyclerAdapter implements MZViewHolder<BannerBean.ResultBean> {

    private List<BannerBean.ResultBean> mBeanList;
    private Context mContext;
    private SimpleDraweeView mBannerImage;

    public BannerRecyclerAdapter(List<BannerBean.ResultBean> beanList, Context context) {
        mBeanList = beanList;
        mContext = context;
    }

    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from( context ).inflate( R.layout.fragment_adapter_banner, null );
        mBannerImage = view.findViewById( R.id.banner_image );
        return view;
    }

    @Override
    public void onBind(Context context, int i, BannerBean.ResultBean integer) {
        Uri parse = Uri.parse( mBeanList.get( i ).getImageUrl() );
        mBannerImage.setImageURI( parse );
    }

}
