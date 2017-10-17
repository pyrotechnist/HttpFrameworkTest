package com.example.longyuan.httpframeworktest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.longyuan.httpframeworktest.network.api.PetApi;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {

    @Inject
    PetApi mPetApi;

    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getAppComponent().inject(this);

        mTextView = (TextView) findViewById(R.id.text);

        mPetApi.getString()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> mTextView.setText(data));

    }
}
