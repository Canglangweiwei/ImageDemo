package com.loveplusplus.demo;

import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.RelativeLayout;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.animation.ScaleInAnimation;
import com.google.gson.Gson;
import com.jaydenxiao.common.baseapp.AppCache;
import com.jaydenxiao.common.commonwidget.NormalTitleBar;
import com.loveplusplus.demo.adapter.CircleAdapter;
import com.loveplusplus.demo.base.BaseActivity;
import com.loveplusplus.demo.bean.BaseBean;
import com.loveplusplus.demo.util.DatasUtil;
import com.loveplusplus.demo.widget.ZoneHeaderView;

import butterknife.Bind;


/**
 * 动态
 */
public class CircleZoneActivity extends BaseActivity {

    @Bind(R.id.drawer_layout)
    RelativeLayout drawerLayout;

    @Bind(R.id.ntb)
    NormalTitleBar ntb;
    @Bind(R.id.irc)
    IRecyclerView irc;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    private CircleAdapter mAdapter;

    // 初始化头部未读消息
    private ZoneHeaderView zoneHeaderView;

    @Override
    protected int initContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initUi() {
        initToolbar();

        // 初始化头部未读消息
        zoneHeaderView = new ZoneHeaderView(this);
        zoneHeaderView.setData(getString(R.string.nick_name), AppCache.getInstance().getIcon(), null);
        irc.addHeaderView(zoneHeaderView);

        mAdapter = new CircleAdapter(this);
        mAdapter.openLoadAnimation(new ScaleInAnimation());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        irc.setLayoutManager(linearLayoutManager);
        irc.setAdapter(mAdapter);
    }

    @Override
    protected void initDatas() {
        new Get_Data().execute();
    }

    @Override
    protected void initListener() {
        irc.setRefreshEnabled(false);
        irc.setLoadMoreEnabled(false);

        zoneHeaderView.setUseravaterListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInfoActivity.startAction(CircleZoneActivity.this);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irc.smoothScrollToPosition(0);
            }
        });
    }

    /**
     * 初始化标题栏
     */
    private void initToolbar() {
        // 标题栏
        ntb.setTitleText(getString(R.string.circle_zone));
        // 点击返回
        ntb.setOnBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        // 右侧按钮
        ntb.setRightTitleVisibility(true);
        ntb.setRightTitle(getString(R.string.zone_publish_title));
        ntb.setOnRightTextListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                CirclePublishActivity.startAction(CircleZoneActivity.this);
            }
        });
    }

    private class Get_Data extends AsyncTask<Void, Void, BaseBean> {

        @Override
        protected BaseBean doInBackground(Void... params) {
            Gson gson = new Gson();
            return gson.fromJson(DatasUtil.json, BaseBean.class);
        }

        @Override
        protected void onPostExecute(BaseBean result) {
            mAdapter.reset(result.getImgs());
        }
    }

    private long newTime;

    /**
     * 监听返回键
     */
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - newTime > 2000) {
            newTime = System.currentTimeMillis();
            Snackbar snackbar = Snackbar.make(drawerLayout, getString(R.string.press_twice_exit), Snackbar.LENGTH_SHORT);
            snackbar.setAction(R.string.exit_directly, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppApplication.get(getApplicationContext()).finishAllActivity();
                }
            });
            snackbar.show();
        } else {
            moveTaskToBack(true);
        }
    }
}
