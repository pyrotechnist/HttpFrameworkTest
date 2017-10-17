package com.example.longyuan.httpframeworktest.network.api;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by LONGYUAN on 2017/10/17.
 */

public interface PetApi {

    @GET("/pet/adore")
    Observable<String> getString();
}
