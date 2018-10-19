package com.shimy.nestscroll;

import android.app.Application;
import android.content.Context;

public class AppApplication extends Application {
    private static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this;
    }

    public static Context getAppContext() {
        return mAppContext;
    }
}
