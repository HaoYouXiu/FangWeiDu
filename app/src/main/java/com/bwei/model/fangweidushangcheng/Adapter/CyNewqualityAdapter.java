package com.bwei.model.fangweidushangcheng.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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

    // private static final int RXXP_TYPE = 0;
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
//                mView = LayoutInflater.from( mContext ).inflate( R.layout., null );

                break;
            case 1:
                mView = LayoutInflater.from( mContext ).inflate( R.layout.home_newquality1, null );

                break;
            case 2:
                mView = LayoutInflater.from( mContext ).inflate( R.layout.home_life1, null );

                break;
            case 3:
                mView = LayoutInflater.from(mContext).inflate( R.layout.home_fashion1, viewGroup, false );

                break;
        }

        ViewHolder holder = new ViewHolder( mView );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
          switch (getItemViewType( i )){
              case 0:
//                  ViewHolder viewHolder1 = (ViewHolder) viewHolder;
//                  viewHolder1.
                  break;
              case 1:
                XPHolder xpHolder = (XPHolder) viewHolder;
                NewQualityAdapter newQualityAdapter = new NewQualityAdapter( mContext,mList );
                xpHolder.fragmentCyNewquality.setAdapter( newQualityAdapter );
                  break;
              case 2:

                  break;
              case 3:

                  break;
          }

    }


    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
//
//           private MZBannerView mMZBannerView;
//        private final ImageView nqImage;
//        private final TextView nqName, nqPrice;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
//            mMZBannerView = itemView.findViewById( R.id. home_carousel);
//            nqImage = (ImageView) itemView.findViewById( R.id.nq_image );
//            nqName = (TextView) itemView.findViewById( R.id.nq_name );
//            nqPrice = (TextView) itemView.findViewById( R.id.nq_price );
        }
    }
    public class XPHolder extends RecyclerView.ViewHolder{

        private final ImageView fragmentHotproducts;
        private final RecyclerView fragmentCyNewquality;

        public XPHolder(@NonNull View itemView) {
            super( itemView );
            fragmentHotproducts = (ImageView) itemView.findViewById( R.id.fragment_hotproducts );
            fragmentCyNewquality = (RecyclerView) itemView.findViewById( R.id.fragment_cy_newquality );
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
