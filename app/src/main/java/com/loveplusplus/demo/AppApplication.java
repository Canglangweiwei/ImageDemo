package com.loveplusplus.demo;

import android.app.Activity;
import android.content.Context;

import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.loveplusplus.demo.config.Constants;

import java.util.Stack;

/**
 * APPLICATION
 */
@SuppressWarnings("ALL")
public class AppApplication extends BaseApplication {

    public static AppApplication sApp;

    private Stack<Activity> activityStack;// activity栈

    public static AppApplication get(Context context) {
        return (AppApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        LogUtils.logInit(Constants.LOG_DEBUG);
    }

    /**
     * 把一个activity压入栈列中
     *
     * @param actvity
     */
    public void pushActivityToStack(Activity actvity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(actvity);
    }

    /**
     * 获取栈顶的activity，先进后出原则
     */
    public Activity getLastActivityFromStack() {
        return activityStack.lastElement();
    }

    /**
     * 从栈列中移除一个activity
     *
     * @param activity
     */
    public void popActivityFromStack(Activity activity) {
        if (activityStack != null && activityStack.size() > 0) {
            if (activity != null) {
                activity.finish();
                activityStack.remove(activity);
                activity = null;
            }
        }
    }

    /**
     * 退出所有activity
     */
    public void finishAllActivity() {
        if (activityStack != null) {
            while (activityStack.size() > 0) {
                Activity activity = getLastActivityFromStack();
                if (activity == null) {
                    break;
                }
                popActivityFromStack(activity);
            }
        }
    }
}
