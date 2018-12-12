package com.bwei.model.fangweidushangcheng.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.model.fangweidushangcheng.R;
import com.bwei.model.fangweidushangcheng.bean.CircleBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * date:2018/12/12
 * author:郝仁（Thinkpad)
 * function:
 */
public class CiricleRecyclerAdapter extends RecyclerView.Adapter<CiricleRecyclerAdapter.ViewHodel> {
    private Context mContext;
    private List<CircleBean.ResultBean> mList;

    public CiricleRecyclerAdapter(Context context, List<CircleBean.ResultBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate( mContext, R.layout.circle_once,null );
        ViewHodel hodel = new ViewHodel( view );
        return hodel;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel viewHodel, int i) {
        viewHodel.circleoneName.setText( mList.get( i ).getNickName() );
        viewHodel.circleoneData.setText( mList.get( i ).getCreateTime()+"" );
        viewHodel.circleoneContent.setText( mList.get( i ).getContent() );
        Uri parse = Uri.parse( mList.get( i ).getHeadPic() );
        viewHodel.circleoneIocn.setImageURI( parse );
        Glide.with( mContext ).load( mList.get( i ).getImage() ).into( viewHodel.circleoneImage1 );
        Glide.with( mContext ).load( mList.get( i ).getImage() ).into( viewHodel.circleoneImage2 );
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHodel extends RecyclerView.ViewHolder {

        private final TextView circleoneContent, circleoneName, circleoneData;
        private final ImageView circleoneImage1, circleoneImage2;
        private final SimpleDraweeView circleoneIocn;

        public ViewHodel(@NonNull View itemView) {
            super( itemView );
            circleoneIocn = (SimpleDraweeView) itemView.findViewById( R.id.circleone_iocn );
            circleoneName = (TextView)itemView.findViewById( R.id.circleone_name );
            circleoneData = (TextView)itemView.findViewById( R.id.circleone_data );
            circleoneContent = (TextView)itemView.findViewById( R.id.circleone_content );
            circleoneImage1 = (ImageView) itemView.findViewById( R.id.circleone_image1 );
            circleoneImage2 = (ImageView) itemView.findViewById( R.id.circleone_image2 );
        }
    }
}
