package com.example.longyuan.httpframeworktest;

import android.app.Application;

import com.example.longyuan.httpframeworktest.network.injection.NetworkModule;

/**
 * Created by LONGYUAN on 2017/10/17.
 */

public class App extends Application {


    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .networkModule(new NetworkModule("http://10.0.2.2:1337"))
                .build();

    }

    public static AppComponent getAppComponent() {

        return mAppComponent;
    }
}
