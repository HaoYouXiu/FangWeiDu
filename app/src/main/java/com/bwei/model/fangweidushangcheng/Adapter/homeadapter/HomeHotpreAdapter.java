package com.bwei.model.fangweidushangcheng.Adapter.homeadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.model.fangweidushangcheng.R;
import com.bwei.model.fangweidushangcheng.bean.HomeHotpreBean;

import java.util.List;

/**
 * date:2018/12/13
 * author:郝仁（Thinkpad)
 * function:
 */
public class HomeHotpreAdapter extends RecyclerView.Adapter<HomeHotpreAdapter.ViewHoder> {
    private Context mContext;
    private List<HomeHotpreBean.ResultBean> mList;

    public HomeHotpreAdapter(Context context, List<HomeHotpreBean.ResultBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate( mContext, R.layout.home_hotpre_adapter, null );
        ViewHoder hoder = new ViewHoder( view );
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, int i) {
        ViewHoder.adapterContent.setText( mList.get( i ).getCommodityName() );
        ViewHoder.adapterMoney.setText( "￥" + mList.get( i ).getPrice() );
//        ViewHoder.adapterNum.setText( mList.get( i ).getSaleNum() );
        Glide.with( mContext ).load( mList.get( i ).getMasterPic() ).into( ViewHoder.adapterImage );
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHoder extends RecyclerView.ViewHolder {

        private static ImageView adapterImage;
        private static TextView adapterContent, adapterMoney, adapterNum;

        public ViewHoder(@NonNull View itemView) {
            super( itemView );
            adapterImage = (ImageView) itemView.findViewById( R.id.adapter_image );
            adapterContent = (TextView) itemView.findViewById( R.id.adapter_content );
            adapterMoney = (TextView) itemView.findViewById( R.id.adapter_money );
            adapterNum = (TextView) itemView.findViewById( R.id.adapter_num );
        }
    }
}
