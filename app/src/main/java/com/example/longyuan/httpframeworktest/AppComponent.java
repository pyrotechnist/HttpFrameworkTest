package com.example.longyuan.httpframeworktest;

import com.example.longyuan.httpframeworktest.network.injection.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by LONGYUAN on 2017/10/17.
 */

@Singleton
@Component(modules = {NetworkModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

}
