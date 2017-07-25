package com.loveplusplus.demo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaydenxiao.common.commonutils.ImageLoaderUtils;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.loveplusplus.demo.base.BaseActivity;
import com.loveplusplus.demo.util.DatasUtil;

import butterknife.Bind;

/**
 * <p>
 * 用户信息页
 * </p>
 * Created by Administrator on 2017/7/18 0018.
 */
@SuppressWarnings("ALL")
public class UserInfoActivity extends BaseActivity
        implements Toolbar.OnMenuItemClickListener {

    @Bind(R.id.main_bg_iv)
    ImageView mUserImgBg;
    @Bind(R.id.toolBar)
    Toolbar toolbar;
    @Bind(R.id.user_name_tv)
    TextView mUserNameTv;
    @Bind(R.id.user_real_name_tv)
    TextView mUserRealNameTv;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @Bind(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;
    @Bind(R.id.user_address_tv)
    TextView mUserAddressTv;
    @Bind(R.id.user_avatar_civ)
    ImageView mUserAvatarCiv;
    @Bind(R.id.user_info_ll)
    LinearLayout mUserInfoLl;
    @Bind(R.id.signature_tv)
    TextView mSignatureTv;
    @Bind(R.id.user_share_tv)
    TextView mUserShareTv;
    @Bind(R.id.user_reply_tv)
    TextView mUserReplyTv;
    @Bind(R.id.user_follow_tv)
    TextView mUserFollowTv;
    @Bind(R.id.edit_tv)
    TextView mEditTv;
    @Bind(R.id.user_focus_ll)
    LinearLayout mUserFocusLl;
    @Bind(R.id.page_title_tv)
    TextView mPageTitleTv;

    private boolean isShowUserInfo = true;
    private boolean isShowUserFoucs = true;
    private boolean isShowUserDesc = true;
    private boolean isShowTitle = true;

    /**
     * 启动入口
     *
     * @param context 上下文环境
     */
    public static void startAction(Context context) {
        Intent intent = new Intent(context, UserInfoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int initContentView() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void initUi() {
        toolbar.setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

        toolbar.inflateMenu(R.menu.menu_user_info);
        toolbar.setOnMenuItemClickListener(this);
        alphaView(mPageTitleTv, 200, 4);
    }

    @Override
    protected void initDatas() {
        String url = DatasUtil.getRandomPhotoUrl();

        ImageLoaderUtils.displayBlurPhoto(this, mUserImgBg, url);
        ImageLoaderUtils.displayRound(this, mUserAvatarCiv, url);

        String username = getResources().getString(R.string.nick_name);
        mCollapsingToolbar.setTitle(username);
        mPageTitleTv.setText(username);
        mUserNameTv.setText(username);

        mUserAddressTv.setText("青岛");
        mUserShareTv.setText("10");
        mUserReplyTv.setText("13");
        mSignatureTv.setText("简单介绍");


        mUserAddressTv.setVisibility(View.VISIBLE);
        mEditTv.setVisibility(View.GONE);
        toolbar.getMenu().findItem(R.id.action_github).setVisible(true);
        toolbar.getMenu().findItem(R.id.action_email).setVisible(true);
        toolbar.getMenu().findItem(R.id.action_blog).setVisible(true);
    }

    @Override
    protected void initListener() {
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float f = ((float) Math.abs(verticalOffset)) / (float) (mAppBarLayout.getTotalScrollRange());
                appBarScrollChange(f);
            }
        });
    }

    /**
     * 控制控件显示与隐藏
     *
     * @param view
     * @param duration
     * @param i
     */
    private void alphaView(View view, long duration, int i) {
        view.animate().alpha(i == 0 ? 1.0f : 0.0f).setDuration(duration).start();
    }

    /**
     * 设置控件隐藏
     *
     * @param f
     */
    private void appBarScrollChange(float f) {
        // 用户信息
        if (f >= 0.1f) {
            if (isShowUserInfo) {
                alphaView(mUserInfoLl, 200, 4);
                isShowUserInfo = false;
            }
        } else if (!isShowUserInfo) {
            alphaView(mUserInfoLl, 200, 0);
            isShowUserInfo = true;
        }
        // 用户描述
        if (f >= 0.5f) {
            if (isShowUserDesc) {
                alphaView(mSignatureTv, 200, 4);
                isShowUserDesc = false;
            }
        } else if (!isShowUserDesc) {
            alphaView(mSignatureTv, 200, 0);
            mSignatureTv.animate().alpha(0.5f);
            isShowUserDesc = true;
        }
        // 分享、关注、回复
        if (f >= 0.7f) {
            if (isShowUserFoucs) {
                alphaView(mUserFocusLl, 200, 4);
                isShowUserFoucs = false;
            }
        } else if (!isShowUserFoucs) {
            alphaView(mUserFocusLl, 200, 0);
            isShowUserFoucs = true;
        }
        // 页面标题显示
        if (f >= 0.86f) {
            if (!isShowTitle) {
                alphaView(mPageTitleTv, 200, 0);
                isShowTitle = true;
            }
        } else if (isShowTitle) {
            alphaView(mPageTitleTv, 200, 4);
            isShowTitle = false;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_github:
                ToastUitl.showShort("github");
                break;
            case R.id.action_blog:
                ToastUitl.showShort("blog");
                break;
            case R.id.action_email:
                ToastUitl.showShort("email");
                break;
        }
        return true;
    }
}
