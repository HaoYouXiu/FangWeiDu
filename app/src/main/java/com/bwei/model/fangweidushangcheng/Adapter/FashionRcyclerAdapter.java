package com.bwei.model.fangweidushangcheng.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.model.fangweidushangcheng.R;
import com.bwei.model.fangweidushangcheng.bean.HomeBean;

import java.util.List;

/**
 * date:2018/12/9
 * author:郝仁（Thinkpad)
 * function:
 */
public class FashionRcyclerAdapter extends RecyclerView.Adapter<FashionRcyclerAdapter.ViewHolder> {
    private Context mContext;
    private HomeBean.ResultBean mResultBList;

    public FashionRcyclerAdapter(Context context, HomeBean.ResultBean resultBList) {
        mContext = context;
        mResultBList = resultBList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( mContext ).inflate( R.layout.home_fashion, viewGroup, false );
        ViewHolder holder = new ViewHolder( view );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
       viewHolder.fasionName.setText( mResultBList.getMlss().get( 0).getCommodityList().get( i ).getCommodityName());
       viewHolder.fashionPrice.setText( mResultBList.getMlss().get( 0 ).getCommodityList().get( i ).getPrice()+"" );
       Glide.with( mContext ).load( mResultBList.getMlss().get( 0 ).getCommodityList().get( i ).getMasterPic()).into( viewHolder.fashionImage );
    }

    @Override
    public int getItemCount() {
        int size = mResultBList.getMlss().get( 0 ).getCommodityList().size();
        return size;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView fashionImage;
        private final TextView fasionName, fashionPrice;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            fashionImage = (ImageView) itemView.findViewById( R.id.fashion_image );
            fasionName = (TextView) itemView.findViewById( R.id.fasion_name );
            fashionPrice = (TextView) itemView.findViewById( R.id.fashion_price );
        }
    }
}
