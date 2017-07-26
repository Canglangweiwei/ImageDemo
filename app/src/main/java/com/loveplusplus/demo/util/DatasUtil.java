package com.loveplusplus.demo.util;

import java.util.Random;

/**
 * des:假数据
 * Created by xsf
 * on 2016.07.11:14
 */
@SuppressWarnings("ALL")
public class DatasUtil {

    public static String json =
            "{\"result\":200,\"message\":\"ok\",\"imgs\":["
                    + "{\"id\":110,\"isSelf\":false,\"createtime\":\"2017-07-26\",\"avator\":\"http://img0.bdstatic.com/img/image/shouye/leimu/mingxing.jpg\",\"name\":\"美女一\",\"content\":\"大家好，走过往昔，奋斗的汗水刚刚拭去 回首旅途，胜利的笑容正在蔓延 携手今宵，高歌这一路荣耀感动，展望明朝，伙伴们，让我们携手同行\",\"urls\":[\"http://p0.so.qhimg.com/t0152b700cd4dd80a6f.jpg\",\"http://p0.so.qhimg.com/t01010fee16bcc2a75a.jpg\",\"http://p0.so.qhimg.com/t01af3a44abdeacda7f.jpg\"]},"
                    + "{\"id\":111,\"isSelf\":true,\"createtime\":\"2017-07-24\",\"avator\":\"http://img0.bdstatic.com/img/image/shouye/leimu/mingxing2.jpg\",\"name\":\"美女二\",\"content\":\"呵呵呵，一心有一份大海的气魄、一生有一份苍穹的广阔。跨艰难而含笑，厉万险而傲然。一路走来，正是凭借着内心深处这份果敢和英武，让我们不畏惧困境、不畏惧坎坷，迎难而上，谱写出一路高歌。让我们一起来欣赏中华武术。 \",\"urls\":[\"http://d.hiphotos.baidu.com/album/w%3D2048/sign=14b0934b78310a55c424d9f4837d42a9/a8014c086e061d95e9fd3e807af40ad163d9cacb.jpg\", \"http://p2.so.qhimg.com/t010555de030e5a697c.jpg\",\"http://p2.so.qhimg.com/t0108171674d6629c5c.jpg\"]},"
                    + "{\"id\":112,\"isSelf\":false,\"createtime\":\"2017-07-23\",\"avator\":\"http://img0.bdstatic.com/img/image/shouye/leimu/mingxing1.jpg\",\"name\":\"美女三\",\"content\":\"嘿嘿嘿，今天，我们欢聚在一起，踏着新年宁静的钟声，共同迎来了一个平安、祥和、激情的夜晚，首先我代表酒店的老总及全体员工向您的到来表示热烈的欢迎和衷心的感谢！感谢您在这个特殊的节日里选择与我们一起共度，一起狂欢！今晚，我们一起狂欢，一起庆祝元旦这个美好的节日。\",\"urls\":[\"http://g.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=ccd33b46d53f8794d7ff4b26e2207fc9/0d338744ebf81a4c0f993437d62a6059242da6a1.jpg\",\"http://c.hiphotos.bdimg.com/album/s%3D900%3Bq%3D90/sign=b8658f17f3d3572c62e290dcba28121a/5fdf8db1cb134954bb97309a574e9258d0094a47.jpg\",\"http://p0.so.qhimg.com/t0152b700cd4dd80a6f.jpg\",\"http://p2.so.qhimg.com/t01c68e11466c9d4e2c.jpg\",\"http://p4.so.qhimg.com/t01f4a39ce56961c049.jpg\",\"http://p1.so.qhimg.com/t017d58ea5a10984531.jpg\",\"http://p3.so.qhimg.com/t015e582a99e458834d.jpg\",\"http://p0.so.qhimg.com/t01362a161523d0c385.jpg\",\"http://p3.so.qhimg.com/t01e664cb18e89204ed.jpg\",\"http://p1.so.qhimg.com/t0195bb470d93a2870b.jpg\"]},"
                    + "{\"id\":113,\"isSelf\":true,\"createtime\":\"2016-08-13\",\"avator\":\"http://img0.bdstatic.com/img/image/shouye/leimu/mingxing6.jpg\",\"name\":\"美女四\",\"content\":\"嘻嘻嘻，今日天有晴，阳光灿烂；今日地有情，花团锦簇；今日海有情，浪迭千重；今日人有情，欢聚一堂！欢迎来到康美斯大讲堂！\",\"urls\":[\"http://f.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=6b62f61bac6eddc422e7b7f309e0c7c0/6159252dd42a2834510deef55ab5c9ea14cebfa1.jpg\",\"http://g.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=e58fb67bc8ea15ce45eee301863b4bce/a5c27d1ed21b0ef4fd6140a0dcc451da80cb3e47.jpg\",\"http://c.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=cdab1512d000baa1be2c44b3772bc82f/91529822720e0cf3855c96050b46f21fbf09aaa1.jpg\",\"http://p3.so.qhimg.com/t01e2cf1aa2453b47b8.jpg\",\"http://p0.so.qhimg.com/t01af9cf943d225bc0f.jpg\",\"http://p1.so.qhimg.com/t01980f97779b3261db.jpg\",\"http://p2.so.qhimg.com/t0149c7f8a88c679032.jpg\",\"http://p3.so.qhimg.com/t010fdce3595f0c72bd.jpg\",\"http://p3.so.qhimg.com/t01e2cf1aa2453b47b8.jpg\"]},"
                    + "{\"id\":114,\"isSelf\":false,\"createtime\":\"2016-07-17\",\"avator\":\"http://img0.bdstatic.com/img/image/shouye/leimu/mingxing4.jpg\",\"name\":\"美女五\",\"content\":\"哈哈，大家好啊，各位亲爱的伙伴，大家好！生命的每一次重逢绝非偶然，我做梦都没有想到今天能与大家在此相逢，这是我们几千年来有约而今天的相识、相逢。让我们为这种相逢、这种缘分给一个热烈的掌声。人与人之间，随缘而聚，缘尽而散。聚时尽其在我，散时尽其在人。既是相识，既是相逢，有恩便无怨，有爱便无恨。得与失，获得与付出，求心之所安。存有随缘之心，完美故可喜，缺陷也是美，纵使一刹那也是永恒！上下几千年，人口近百亿，你我能相识，相聚在一起，你说珍奇不珍奇。所以想你应该，爱你应该，祝福你更应该！（自觉热烈的长时间鼓掌）。其实两三天的课程没有状元老师只有状元学生，两三天对于人的一生是短暂的，但是，这两三天是我的生命，也是在座的各位的生命，我会用我的生命来与各位分享，与各位见证，与各位共同达成。同时，也希望各位用生命投入这两三天。\",\"urls\":[\"http://p0.so.qhimg.com/t01010fee16bcc2a75a.jpg\",\"http://p4.so.qhimg.com/t0128f3bf87aae0d199.jpg\",\"http://p3.so.qhimg.com/t015cfe501583ccdef8.jpg\",\"http://p2.so.qhimg.com/t01b2c879f6b27e5c02.jpg\",\"http://p0.so.qhimg.com/t01af9cf943d225bc0f.jpg\",\"http://p1.so.qhimg.com/t01980f97779b3261db.jpg\",\"http://p3.so.qhimg.com/t01e664cb18e89204ed.jpg\",\"http://p0.so.qhimg.com/t01a8caf0911a4f485a.jpg\",\"http://p3.so.qhimg.com/t015e582a99e458834d.jpg\"]},"
                    + "{\"id\":115,\"isSelf\":true,\"createtime\":\"2015-06-06\",\"avator\":\"http://g.hiphotos.baidu.com/image/pic/item/8d5494eef01f3a29a3b0e6c49b25bc315c607cbb.jpg\",\"name\":\"美女六\",\"content\":\"苹果（学名：Malus pumila）是水果的一种，是蔷薇科苹果亚科苹果属植物，其树为落叶乔木。苹果的果实富含矿物质和维生素，是人们经常食用的水果之一。\",\"urls\":[\"http://h.hiphotos.baidu.com/image/pic/item/30adcbef76094b36db47d2e4a1cc7cd98c109de6.jpg\",\"http://h.hiphotos.baidu.com/image/h%3D200/sign=9d4948d52c738bd4db21b531918a876c/6a600c338744ebf85db15337dbf9d72a6159a7f1.jpg\",\"http://g.hiphotos.baidu.com/image/pic/item/8d5494eef01f3a29a3b0e6c49b25bc315c607cbb.jpg\",\"http://d.hiphotos.baidu.com/image/pic/item/e4dde71190ef76c6e453882a9f16fdfaaf516729.jpg\"]}]}";

    /**
     * 图片
     */
    private static String[] Urls = {"http://d.hiphotos.baidu.com/image/pic/item/e4dde71190ef76c6e453882a9f16fdfaaf516729.jpg",
            "http://h.hiphotos.baidu.com/image/pic/item/30adcbef76094b36db47d2e4a1cc7cd98c109de6.jpg",
            "http://g.hiphotos.baidu.com/image/pic/item/0d338744ebf81a4c27dc0dcdd52a6059242da6cc.jpg",
            "http://c.hiphotos.baidu.com/image/h%3D200/sign=d21f63f99d3df8dcb93d8891fd1072bf/78310a55b319ebc415951b978026cffc1f1716ca.jpg",
            "http://d.hiphotos.baidu.com/image/pic/item/54fbb2fb43166d22dc28839a442309f79052d265.jpg",
            "http://c.hiphotos.baidu.com/image/pic/item/03087bf40ad162d9d0e7560313dfa9ec8a13cda7.jpg",
            "http://g.hiphotos.baidu.com/image/h%3D200/sign=16f4ef3e35adcbef1e3479069cae2e0e/6d81800a19d8bc3e7763d030868ba61ea9d345e5.jpg",
            "http://g.hiphotos.baidu.com/image/pic/item/8d5494eef01f3a29a3b0e6c49b25bc315c607cbb.jpg",
            "http://c.hiphotos.baidu.com/image/h%3D200/sign=548da2d73f6d55fbdac671265d224f40/a044ad345982b2b7a2b8f7cd33adcbef76099b90.jpg",
            "http://g.hiphotos.baidu.com/image/pic/item/7acb0a46f21fbe09359315d16f600c338644ad22.jpg",
            "http://h.hiphotos.baidu.com/image/h%3D200/sign=9d4948d52c738bd4db21b531918a876c/6a600c338744ebf85db15337dbf9d72a6159a7f1.jpg",
            "http://e.hiphotos.baidu.com/image/h%3D200/sign=7683f02abc096b639e1959503c328733/203fb80e7bec54e74a142d1bbb389b504fc26a3e.jpg"};

    /**
     * 获取随机图片串
     */
    public static String getRandomPhotoUrlString(int num) {
        StringBuilder sdbResult = new StringBuilder();
        if (num > 0) {
            String[] photoUrls = new String[num > 9 ? 9 : num];
            for (int i = 0; i < num; i++) {
                if (sdbResult.length() > 0) {
                    sdbResult.append(";").append(Urls[new Random().nextInt(Urls.length)]);
                } else {
                    sdbResult.append(Urls[new Random().nextInt(Urls.length)]);
                }
            }
        }
        return sdbResult.toString();
    }

    /**
     * 获取随机图片串
     *
     * @return
     */
    public static String getRandomPhotoUrl() {
        return Urls[new Random().nextInt(Urls.length)];
    }
}
