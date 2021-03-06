package com.loveplusplus.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.aspsine.irecyclerview.baseadapter.BaseReclyerViewAdapter;
import com.loveplusplus.demo.bean.MessageBean;
import com.loveplusplus.demo.viewholder.ZoneViewHolder;

/**
 * des: 圈子列表的adapter
 * Created by xsf
 * on 2016.08.14:19
 */
@SuppressWarnings("ALL")
public class CircleAdapter extends BaseReclyerViewAdapter<MessageBean> {

    public CircleAdapter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ZoneViewHolder.create(mContext);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (holder instanceof ZoneViewHolder) {
            ((ZoneViewHolder) holder).setData(get(position), position);
        }
    }
}
