package com.loveplusplus.demo.widget;

import android.text.TextUtils;

import java.io.File;


/**
 * des:判断图片地址是否合法
 * Created by xsf
 * on 2016.04.10:36
 */
@SuppressWarnings("ALL")
public class ImageUtil {

    private final static String BASE_PHOTO_URL = "";

    public static String getImageUrl(String url) {
        if (!TextUtils.isEmpty(url)) {
            if (url.contains("http") || new File(url).isFile()) {
                return url;
            } else {
                return BASE_PHOTO_URL + url;
            }
        } else {
            return "";
        }
    }
}

