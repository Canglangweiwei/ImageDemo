package com.loveplusplus.demo.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.common.commonutils.ImageLoaderUtils;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.jaydenxiao.common.commonwidget.NoScrollGridView;
import com.jaydenxiao.common.imagePager.BigImagePagerActivity;
import com.loveplusplus.demo.bean.MessageBean;
import com.loveplusplus.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Description：留言板列表
 * </p>
 * Created by weiwei On 2017-4-12 上午9:28:04
 */
@SuppressWarnings("ALL")
public class MsgBoardAdapter extends BaseAdapter {

    private ArrayList<MessageBean> mList;
    private LayoutInflater mInflater;
    private Context mContext;

    public MsgBoardAdapter(Context context, ArrayList<MessageBean> list) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public MessageBean getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_list, null);
            holder.avator = (ImageView) convertView.findViewById(R.id.headIv);
            holder.name = (TextView) convertView.findViewById(R.id.nameTv);
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.gridView = (NoScrollGridView) convertView.findViewById(R.id.gridView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final MessageBean bean = getItem(position);

        // 昵称
        holder.name.setText(bean.getName());
        // 发表内容
        holder.content.setText(bean.getContent());
        // 头像
        ImageLoaderUtils.displayRound(parent.getContext(), holder.avator, bean.getAvator());
        // 头像点击
        holder.avator.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // 跳转图片浏览
                ToastUitl.showShort("头像点击了" + position);
            }
        });

        // 图片点击
        if (bean.getUrls() != null && bean.getUrls().length > 0) {
            holder.gridView.setVisibility(View.VISIBLE);
            holder.gridView.setAdapter(new ImgGridListAdapter(bean.getUrls(), mContext));
            holder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    List<String> photos = new ArrayList<>();
                    for (String url : bean.getUrls()) {
                        photos.add(url);
                    }
                    /**
                     * 查看大图
                     */
                    BigImagePagerActivity.startImagePagerActivity((Activity) mContext, photos, position);
                }
            });
        } else {
            holder.gridView.setVisibility(View.GONE);
        }
        // 查看详情
        convertView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "查看了【 " + bean.getName() + " 】的详情信息", Toast.LENGTH_SHORT)
                        .show();
            }
        });
        return convertView;
    }

    /**
     * <p>
     * 功能描述：持有者
     * </p>
     * Created by weiwei on 2017-5-12 上午11:31:13
     */
    private static class ViewHolder {
        public TextView name;
        public ImageView avator;
        public TextView content;
        public NoScrollGridView gridView;
    }
}
