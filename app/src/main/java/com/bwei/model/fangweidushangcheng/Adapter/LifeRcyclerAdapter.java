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

/**
 * date:2018/12/9
 * author:郝仁（Thinkpad)
 * function:
 */
public class LifeRcyclerAdapter extends RecyclerView.Adapter<LifeRcyclerAdapter.ViewHolder> {
    private Context mContext;
    private HomeBean.ResultBean mResultBList;

    public LifeRcyclerAdapter(Context context, HomeBean.ResultBean resultBList) {
        mContext = context;
        mResultBList = resultBList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( mContext ).inflate( R.layout.home_life, viewGroup, false );
        ViewHolder holder = new ViewHolder( view );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
       viewHolder.lifeName.setText( mResultBList.getPzsh().get( 0 ).getCommodityList().get( i ).getCommodityName());
       viewHolder.lifePrice.setText( mResultBList.getPzsh().get( 0 ).getCommodityList().get( i ).getPrice()+"" );
       Glide.with( mContext ).load( mResultBList.getPzsh().get( 0 ).getCommodityList().get( i ).getMasterPic()).into( viewHolder.lifeImage );
    }

    @Override
    public int getItemCount() {
        int size = mResultBList.getPzsh().get( 0 ).getCommodityList().size();
        return size;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView lifeImage;
        private final TextView lifeName, lifePrice;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            lifeImage = (ImageView) itemView.findViewById( R.id.life_image );
            lifeName = (TextView) itemView.findViewById( R.id.life_name );
            lifePrice = (TextView) itemView.findViewById( R.id.life_price );
        }
    }
}
