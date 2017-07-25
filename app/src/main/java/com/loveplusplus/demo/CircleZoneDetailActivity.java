package com.loveplusplus.demo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.commonutils.ImageLoaderUtils;
import com.loveplusplus.demo.base.BaseActivity;
import com.loveplusplus.demo.util.ShareUtil;

import butterknife.Bind;

/**
 * <p>
 * 空间详情页
 * </p>
 * Created by Administrator on 2017/7/18 0018.
 */
public class CircleZoneDetailActivity extends BaseActivity
        implements Toolbar.OnMenuItemClickListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.user_img_iv)
    ImageView userImgIv;
    @Bind(R.id.user_name_tv)
    TextView userNameTv;
    @Bind(R.id.user_desc_tv)
    TextView userDescTv;
    @Bind(R.id.webView)
    WebView webView;

    /**
     * 启动入口
     *
     * @param context 上下文环境
     */
    public static void startAction(Context context) {
        Intent intent = new Intent(context, CircleZoneDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int initContentView() {
        return R.layout.activity_zone_detail;
    }

    @Override
    protected void initUi() {
        initToolbar();
        initViewDetail();
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initListener() {

    }

    /**
     * 初始化页面
     */
    private void initToolbar() {
        toolbar.setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.inflateMenu(R.menu.menu_zone_detail);
        toolbar.setOnMenuItemClickListener(this);
    }

    /**
     * 数据加载
     */
    private void initViewDetail() {
        String url_avater = getResources().getString(R.string.zangao_avater);
        ImageLoaderUtils.displayRound(this, userImgIv, url_avater);
        userNameTv.setText("藏獒");
        userDescTv.setText(R.string.zangao_desc);

        WebSettings webSettings = webView.getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.loadUrl(getResources().getString(R.string.zangao_page));
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }
        });
        webView.setOnKeyListener(new View.OnKeyListener() { // webview can
            // go back
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                    webView.goBack();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                ShareUtil.share(this, "分享 "
                        + getResources().getString(R.string.nick_name) + " 的文章藏獒： "
                        + getResources().getString(R.string.zangao_page) + "「来自:zone」");
                break;
        }
        return true;
    }

    /**
     * 清空缓存
     */
    @Override
    protected void onDestroy() {
        webView.clearCache(false);
        webView.removeAllViews();
        webView.destroy();
        super.onDestroy();
    }
}
