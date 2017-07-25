package com.loveplusplus.demo;

import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.animation.ScaleInAnimation;
import com.google.gson.Gson;
import com.jaydenxiao.common.baseapp.AppCache;
import com.jaydenxiao.common.commonwidget.NormalTitleBar;
import com.loveplusplus.demo.adapter.CircleAdapter;
import com.loveplusplus.demo.base.BaseActivity;
import com.loveplusplus.demo.bean.BaseBean;
import com.loveplusplus.demo.widget.ZoneHeaderView;

import butterknife.Bind;


/**
 * 动态
 */
public class CircleZoneActivity extends BaseActivity {

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
        ntb.setRightTitle("发布说说");
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
            String json =
                    "{\"result\":200,\"message\":\"ok\",imgs:["
                            + "{\"id\":110,\"isMine\":false,\"avator\":\"http://img0.bdstatic.com/img/image/shouye/leimu/mingxing.jpg\",\"name\":\"美女一\",\"content\":\"大家好，走过往昔，奋斗的汗水刚刚拭去 回首旅途，胜利的笑容正在蔓延 携手今宵，高歌这一路荣耀感动，展望明朝，伙伴们，让我们携手同行\",\"urls\":[\"http://p0.so.qhimg.com/t0152b700cd4dd80a6f.jpg\",\"http://p0.so.qhimg.com/t01010fee16bcc2a75a.jpg\",\"http://p0.so.qhimg.com/t01af3a44abdeacda7f.jpg\"]},"
                            + "{\"id\":111,\"isMine\":true,\"avator\":\"http://img0.bdstatic.com/img/image/shouye/leimu/mingxing2.jpg\",\"name\":\"美女二\",\"content\":\"呵呵呵，一心有一份大海的气魄、一生有一份苍穹的广阔。跨艰难而含笑，厉万险而傲然。一路走来，正是凭借着内心深处这份果敢和英武，让我们不畏惧困境、不畏惧坎坷，迎难而上，谱写出一路高歌。让我们一起来欣赏中华武术。 \",\"urls\":[\"http://d.hiphotos.baidu.com/album/w%3D2048/sign=14b0934b78310a55c424d9f4837d42a9/a8014c086e061d95e9fd3e807af40ad163d9cacb.jpg\", \"http://p2.so.qhimg.com/t010555de030e5a697c.jpg\",\"http://p2.so.qhimg.com/t0108171674d6629c5c.jpg\"]},"
                            + "{\"id\":112,\"isMine\":false,\"avator\":\"http://img0.bdstatic.com/img/image/shouye/leimu/mingxing1.jpg\",\"name\":\"美女三\",\"content\":\"嘿嘿嘿，今天，我们欢聚在一起，踏着新年宁静的钟声，共同迎来了一个平安、祥和、激情的夜晚，首先我代表酒店的老总及全体员工向您的到来表示热烈的欢迎和衷心的感谢！感谢您在这个特殊的节日里选择与我们一起共度，一起狂欢！今晚，我们一起狂欢，一起庆祝元旦这个美好的节日。\",\"urls\":[\"http://g.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=ccd33b46d53f8794d7ff4b26e2207fc9/0d338744ebf81a4c0f993437d62a6059242da6a1.jpg\",\"http://c.hiphotos.bdimg.com/album/s%3D900%3Bq%3D90/sign=b8658f17f3d3572c62e290dcba28121a/5fdf8db1cb134954bb97309a574e9258d0094a47.jpg\",\"http://p0.so.qhimg.com/t0152b700cd4dd80a6f.jpg\",\"http://p2.so.qhimg.com/t01c68e11466c9d4e2c.jpg\",\"http://p4.so.qhimg.com/t01f4a39ce56961c049.jpg\",\"http://p1.so.qhimg.com/t017d58ea5a10984531.jpg\",\"http://p3.so.qhimg.com/t015e582a99e458834d.jpg\",\"http://p0.so.qhimg.com/t01362a161523d0c385.jpg\",\"http://p3.so.qhimg.com/t01e664cb18e89204ed.jpg\",\"http://p1.so.qhimg.com/t0195bb470d93a2870b.jpg\"]},"
                            + "{\"id\":113,\"isMine\":true,\"avator\":\"http://img0.bdstatic.com/img/image/shouye/leimu/mingxing6.jpg\",\"name\":\"美女四\",\"content\":\"嘻嘻嘻，今日天有晴，阳光灿烂；今日地有情，花团锦簇；今日海有情，浪迭千重；今日人有情，欢聚一堂！欢迎来到康美斯大讲堂！\",\"urls\":[\"http://f.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=6b62f61bac6eddc422e7b7f309e0c7c0/6159252dd42a2834510deef55ab5c9ea14cebfa1.jpg\",\"http://g.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=e58fb67bc8ea15ce45eee301863b4bce/a5c27d1ed21b0ef4fd6140a0dcc451da80cb3e47.jpg\",\"http://c.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=cdab1512d000baa1be2c44b3772bc82f/91529822720e0cf3855c96050b46f21fbf09aaa1.jpg\",\"http://p3.so.qhimg.com/t01e2cf1aa2453b47b8.jpg\",\"http://p0.so.qhimg.com/t01af9cf943d225bc0f.jpg\",\"http://p1.so.qhimg.com/t01980f97779b3261db.jpg\",\"http://p2.so.qhimg.com/t0149c7f8a88c679032.jpg\",\"http://p3.so.qhimg.com/t010fdce3595f0c72bd.jpg\",\"http://p3.so.qhimg.com/t01e2cf1aa2453b47b8.jpg\"]},"
                            + "{\"id\":114,\"isMine\":false,\"avator\":\"http://img0.bdstatic.com/img/image/shouye/leimu/mingxing4.jpg\",\"name\":\"美女五\",\"content\":\"哈哈，大家好啊，各位亲爱的伙伴，大家好！生命的每一次重逢绝非偶然，我做梦都没有想到今天能与大家在此相逢，这是我们几千年来有约而今天的相识、相逢。让我们为这种相逢、这种缘分给一个热烈的掌声。人与人之间，随缘而聚，缘尽而散。聚时尽其在我，散时尽其在人。既是相识，既是相逢，有恩便无怨，有爱便无恨。得与失，获得与付出，求心之所安。存有随缘之心，完美故可喜，缺陷也是美，纵使一刹那也是永恒！上下几千年，人口近百亿，你我能相识，相聚在一起，你说珍奇不珍奇。所以想你应该，爱你应该，祝福你更应该！（自觉热烈的长时间鼓掌）。其实两三天的课程没有状元老师只有状元学生，两三天对于人的一生是短暂的，但是，这两三天是我的生命，也是在座的各位的生命，我会用我的生命来与各位分享，与各位见证，与各位共同达成。同时，也希望各位用生命投入这两三天。\",\"urls\":[\"http://p0.so.qhimg.com/t01010fee16bcc2a75a.jpg\",\"http://p4.so.qhimg.com/t0128f3bf87aae0d199.jpg\",\"http://p3.so.qhimg.com/t015cfe501583ccdef8.jpg\",\"http://p2.so.qhimg.com/t01b2c879f6b27e5c02.jpg\",\"http://p0.so.qhimg.com/t01af9cf943d225bc0f.jpg\",\"http://p1.so.qhimg.com/t01980f97779b3261db.jpg\",\"http://p3.so.qhimg.com/t01e664cb18e89204ed.jpg\",\"http://p0.so.qhimg.com/t01a8caf0911a4f485a.jpg\",\"http://p3.so.qhimg.com/t015e582a99e458834d.jpg\"]}]}";
            Gson gson = new Gson();
            return gson.fromJson(json, BaseBean.class);
        }

        @Override
        protected void onPostExecute(BaseBean result) {
            mAdapter.reset(result.getImgs());
        }
    }
}
