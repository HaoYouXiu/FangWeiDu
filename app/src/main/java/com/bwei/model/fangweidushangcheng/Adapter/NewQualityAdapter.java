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
 * date:2018/12/8
 * author:郝仁（Thinkpad)
 * function:
 */
public class NewQualityAdapter extends RecyclerView.Adapter<NewQualityAdapter.ViewHolder> {
    private Context mContext;
    private HomeBean.ResultBean mResultList;

    public NewQualityAdapter(Context context, HomeBean.ResultBean resultList) {
        mContext = context;
        mResultList = resultList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( mContext ).inflate( R.layout.home_newquality, viewGroup, false );
        ViewHolder holder = new ViewHolder( view );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.nqName.setText( mResultList.getRxxp().get( 0 ).getCommodityList().get( i ).getCommodityName());
        viewHolder.nqPrice.setText(mResultList.getRxxp().get( 0).getCommodityList().get(i).getPrice() + "");
        Glide.with( mContext ).load( mResultList.getRxxp().get(0 ).getCommodityList().get( i ).getMasterPic() ).into( viewHolder.nqImage );
    }

    @Override
    public int getItemCount() {
        int size = mResultList.getRxxp().get( 0 ).getCommodityList().size();
        return size;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView nqImage;
        private final TextView nqName, nqPrice;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            nqImage = (ImageView) itemView.findViewById( R.id.nq_image );
            nqName = (TextView) itemView.findViewById( R.id.nq_name );
            nqPrice = (TextView) itemView.findViewById( R.id.nq_price );
        }
    }
}
