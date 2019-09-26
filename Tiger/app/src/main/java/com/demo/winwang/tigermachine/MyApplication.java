package com.demo.winwang.tigermachine;

import android.app.Application;

import com.demo.winwang.tigermachine.utils.ScreenFitHelper;

/**
 * Created by admin on 2018/3/12.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new ScreenFitHelper(this, 750).activate();//激活屏幕适配方案
    }
}
