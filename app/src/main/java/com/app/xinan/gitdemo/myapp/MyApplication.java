package com.app.xinan.gitdemo.myapp;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2018/3/25.
 */

public class MyApplication extends Application {
    private static RequestQueue requestQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }
    public static RequestQueue getRequestQueue(){
        return requestQueue;
    }
}
