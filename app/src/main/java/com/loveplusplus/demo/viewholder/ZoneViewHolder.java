package com.loveplusplus.demo.viewholder;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.commonutils.ImageLoaderUtils;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.jaydenxiao.common.imagePager.BigImagePagerActivity;
import com.loveplusplus.demo.R;
import com.loveplusplus.demo.CircleZoneDetailActivity;
import com.loveplusplus.demo.bean.MessageBean;
import com.loveplusplus.demo.util.DatasUtil;
import com.loveplusplus.demo.widget.ExpandableTextView;
import com.loveplusplus.demo.widget.MultiImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * des：圈子viewholder
 * Created by weiwei on 2017/06/14
 */
@SuppressWarnings("ALL")
public class ZoneViewHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    private View itemView;
    private MessageBean circleMessage;
    private int position;

    /**
     * 头像
     */
    private ImageView headIv;

    /**
     * 昵称
     */
    private TextView nameTv;

    /**
     * 删除
     */
    private TextView deleteBtn;

    /**
     * 动态的内容
     */
    private ExpandableTextView contentTv;

    /**
     * 图片
     */
    private MultiImageView multiImageView;

    public static ZoneViewHolder create(Context context) {
        ZoneViewHolder imageViewHolder = new ZoneViewHolder(LayoutInflater.from(context).inflate(R.layout.item_circle_zone, null), context);
        return imageViewHolder;
    }

    public ZoneViewHolder(View itemView, final Context context) {
        super(itemView);
        this.itemView = itemView;
        this.mContext = context;
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        ViewStub linkOrImgViewStub = (ViewStub) itemView.findViewById(R.id.linkOrImgViewStub);
        linkOrImgViewStub.setLayoutResource(R.layout.item_circle_viewstub_imgbody);
        linkOrImgViewStub.inflate();
        MultiImageView multiImageView = (MultiImageView) itemView.findViewById(R.id.multiImageView);
        if (multiImageView != null) {
            this.multiImageView = multiImageView;
        }
        headIv = (ImageView) itemView.findViewById(R.id.avator);
        nameTv = (TextView) itemView.findViewById(R.id.name);
        contentTv = (ExpandableTextView) itemView.findViewById(R.id.contentTv);
        deleteBtn = (TextView) itemView.findViewById(R.id.deleteBtn);
    }

    /**
     * 设置数据
     */
    public void setData(MessageBean messageBean, final int pos) {
        if (messageBean == null) {
            return;
        }
        this.circleMessage = messageBean;
        this.position = pos;
        // 头像
        ImageLoaderUtils.displayRound(mContext, headIv, DatasUtil.getRandomPhotoUrl());
        nameTv.setText(circleMessage.getName());
        contentTv.setText(circleMessage.getContent(), position);
        contentTv.setVisibility(TextUtils.isEmpty(circleMessage.getContent()) ? View.GONE : View.VISIBLE);

        // 是否显示删除图标
        deleteBtn.setVisibility(messageBean.isMine() ? View.VISIBLE : View.GONE);
        deleteBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 删除
                ToastUitl.showShort("删除了第" + position + "条数据");
            }
        });

        final String[] datas = circleMessage.getUrls();
        final List<String> photos = new ArrayList<>();

        if (datas != null && datas.length > 0) {
            for (String data : datas) {
                photos.add(data);
            }
            multiImageView.setVisibility(View.VISIBLE);
            multiImageView.setList(photos);
            multiImageView.setOnItemClickListener(new MultiImageView.OnEveryPhotoClickListener() {

                @Override
                public void onPhotoClick(View view, int position) {
                    /**
                     * 查看大图
                     */
                    BigImagePagerActivity.startImagePagerActivity((Activity) mContext, photos, position);
                }
            });
        } else {
            multiImageView.setVisibility(View.GONE);
        }

        // 头像点击
        headIv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // 跳到个人朋友圈
                CircleZoneDetailActivity.startAction(mContext);
            }
        });
    }
}
