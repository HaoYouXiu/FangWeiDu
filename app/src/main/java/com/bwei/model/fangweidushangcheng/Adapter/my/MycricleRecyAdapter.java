package com.bwei.model.fangweidushangcheng.Adapter.my;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * date:2018/12/13
 * author:郝仁（Thinkpad)
 * function:
 */
public class MycricleRecyAdapter extends RecyclerView.Adapter<MycricleRecyAdapter.ViewHolder> {
    private Context mContext;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
        }
    }
}
