package com.app.xinan.gitdemo.myapp;

import android.app.Application;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2018/3/25.
 */

public class MyApplication extends Application {
    private static RequestQueue requestQueue;
    private static final String TAG = "MyApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: "+"执行Application创建方法");
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }
    public static RequestQueue getRequestQueue(){
        return requestQueue;
    }
}
