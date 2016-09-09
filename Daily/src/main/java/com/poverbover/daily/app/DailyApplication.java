package com.poverbover.daily.app;

import android.app.Application;
import android.content.Context;

import com.poverbover.apputillibrary.AppUtil;

import cn.bmob.v3.Bmob;

/**
 * Created by void on 2016/9/6.
 */
public class DailyApplication extends Application{

    private static Context instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        AppUtil.init(this, AppConfig.DEBUG);
        Bmob.initialize(this,AppConfig.BMOB_APP_ID);
        //new UserBmobBean("void","v").save();//创建一个用户
    }

    /**获取应用级context*/
    public static Context getAppContext(){
        return instance;
    }
}
