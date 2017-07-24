package com.loveplusplus.demo;

import com.jaydenxiao.common.baseapp.BaseApplication;


@SuppressWarnings("ALL")
public class MyApplication extends BaseApplication {

    public static MyApplication sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
    }
}
