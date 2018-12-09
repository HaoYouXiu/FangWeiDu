package com.bwei.model.fangweidushangcheng.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.model.fangweidushangcheng.R;
import com.bwei.model.fangweidushangcheng.bean.HomeBean;
import com.zhouwei.mzbanner.MZBannerView;

import java.util.List;

/**
 * date:2018/12/7
 * author:郝仁（Thinkpad)
 * function:
 */
public class CyNewqualityAdapter extends RecyclerView.Adapter{

    private Context mContext;
    private HomeBean.ResultBean mList;

    public CyNewqualityAdapter(Context context, HomeBean.ResultBean list) {
        mContext = context;
        mList = list;
    }

    //    private static final int RXXP_TYPE = 0;
//    private static final int MLSS_TYPE_ = 1;
//    private static final int PZSH_TYPE_ = 2;

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View mView = null;
        switch (i){
            case 0:
                mView = LayoutInflater.from( mContext ).inflate( R.layout.home_newquality, null );

                break;
            case 1:
//                View view = LayoutInflater.from( mContext ).inflate( R.layout.fragment_adapter_banner, null );

                break;
            case 2:
//                View view = LayoutInflater.from( mContext ).inflate( R.layout.fragment_adapter_banner, null );

                break;
        }
//        View view = LayoutInflater.from(mContext).inflate( R.layout.home_newquality, viewGroup, false );
        ViewHolder holder = new ViewHolder( mView );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
          switch (i){
              case 0:
                  ViewHolder viewHolder1 = (ViewHolder) viewHolder;
                  break;
              case 1:
                  break;
              case 2:
                  break;
          }
//        viewHolder.nqName.setText( mList.get(i).getRxxp().get( i ).getCommodityList().get(i).getPrice());
//        viewHolder.nqPrice.setText(mList.get(i).getRxxp().get( i ).getCommodityList().get(i).getCommodityName());
//        Glide.with( mContext ).load( mList.get( i ).getRxxp().get( i ).getCommodityList().get( i ).getMasterPic() );

    }


    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

           private MZBannerView mMZBannerView;
//        private final ImageView nqImage;
//        private final TextView nqName, nqPrice;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            mMZBannerView = itemView.findViewById( R.id. home_carousel);
//            nqImage = (ImageView) itemView.findViewById( R.id.nq_image );
//            nqName = (TextView) itemView.findViewById( R.id.nq_name );
//            nqPrice = (TextView) itemView.findViewById( R.id.nq_price );
        }
    }
    public class XPHolder extends RecyclerView.ViewHolder{

        public XPHolder(@NonNull View itemView) {
            super( itemView );
        }
    }
    public class MLSSHolder extends RecyclerView.ViewHolder{

        public MLSSHolder(@NonNull View itemView) {
            super( itemView );
        }
    }
    public class PZSHHolder extends RecyclerView.ViewHolder{

        public PZSHHolder(@NonNull View itemView) {
            super( itemView );
        }
    }

}
