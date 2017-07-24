package com.loveplusplus.demo.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaydenxiao.common.commonutils.FormatUtil;
import com.jaydenxiao.common.commonutils.ImageLoaderUtils;
import com.loveplusplus.demo.R;
import com.loveplusplus.demo.util.DatasUtil;

/**
 * des:圈子消息头
 * Created by xsf
 * on 2016.07.15:18
 */
@SuppressWarnings("ALL")
public class ZoneHeaderView extends LinearLayout {

    private ImageView img_user_bg, img_avater, img_newest_avater;
    private TextView tv_name, tv_not_read_new;
    private LinearLayout ll_not_read_news_root;
    private RelativeLayout rl_not_read_news_root;

    public ZoneHeaderView(Context context) {
        super(context);
        initView();
    }

    public ZoneHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ZoneHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ZoneHeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
        View view = inflate(getContext(), R.layout.item_zone_header, null);
        img_user_bg = (ImageView) view.findViewById(R.id.img_bg);
        img_avater = (ImageView) view.findViewById(R.id.img_avater);
        img_newest_avater = (ImageView) view.findViewById(R.id.img_newest_avater);
        tv_name = (TextView) view.findViewById(R.id.tv_name);
        tv_not_read_new = (TextView) view.findViewById(R.id.tv_not_read_new);
        ll_not_read_news_root = (LinearLayout) view.findViewById(R.id.ll_not_read_news_root);
        rl_not_read_news_root = (RelativeLayout) view.findViewById(R.id.rl_not_read_news_root);
        rl_not_read_news_root.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                ll_not_read_news_root.setVisibility(View.GONE);
            }
        });
        addView(view);
    }

    /**
     * 设置基本信息
     */
    public void setData(String name, String avater, String user_bg) {
        // 用户名
        tv_name.setText(FormatUtil.checkValue(name));
        // 用户头像
        ImageLoaderUtils.displayRound(getContext(), img_avater, DatasUtil.getRandomPhotoUrl());
        // 用户背景
        if (TextUtils.isEmpty(user_bg)) {
            return;
        }
        ImageLoaderUtils.display(getContext(), img_user_bg, user_bg);
    }

    /**
     * 设置用户头像点击事件
     */
    public void setUseravaterListener(OnClickListener l) {
        img_avater.setOnClickListener(l);
    }

    /**
     * 设置未读消息值
     */
    public void setNotReadMsgData(int num, String avater) {
        if (num > 0) {
            ll_not_read_news_root.setVisibility(View.VISIBLE);
            ImageLoaderUtils.displayRound(getContext(), img_newest_avater, DatasUtil.getRandomPhotoUrl());
            tv_not_read_new.setText(String.format(getResources().getString(R.string.circle_zone_not_read_news), String.valueOf(num)));
        } else {
            ll_not_read_news_root.setVisibility(View.GONE);
        }
    }
}
