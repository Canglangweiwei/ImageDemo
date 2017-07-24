package com.loveplusplus.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.jaydenxiao.common.commonutils.ImageLoaderUtils;
import com.loveplusplus.demo.R;

@SuppressWarnings("ALL")
public class ImgGridListAdapter extends BaseAdapter {

    private String[] files;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public ImgGridListAdapter(String[] files, Context context) {
        this.files = files;
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        // 只允许显示9张图片
        int count = 0;
        count = (files == null ? 0 : files.length);
        if (count >= 9) {
            count = 9;
        }
        return count;
    }

    @Override
    public String getItem(int position) {
        return files[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyGridViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new MyGridViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.gridview_item, parent, false);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.album_image);
            convertView.setTag(R.id.imageloader_uri, viewHolder);
        } else {
            viewHolder = (MyGridViewHolder) convertView.getTag(R.id.imageloader_uri);
        }
        String url = getItem(position);
        ImageLoaderUtils.display(mContext, viewHolder.imageView, url);

        return convertView;
    }

    private static class MyGridViewHolder {
        ImageView imageView;
    }
}
