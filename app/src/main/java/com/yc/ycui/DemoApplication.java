package com.yc.ycui;

import android.app.Application;
import android.content.Context;

import com.yc.yclibrary.YcUtils;


public class DemoApplication extends Application {
    private static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext=this;
        YcUtils.init(this);
    }

    public static Context getAppContext() {
        return mAppContext;
    }
}
