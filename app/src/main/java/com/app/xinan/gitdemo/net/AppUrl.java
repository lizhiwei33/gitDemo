package com.app.xinan.gitdemo.net;

/**
 * Created by lzw on 2018/4/1.
 */

public class AppUrl {
    public static String  baseUrl="https://www.sojson.com/open/api/weather/json.shtml?city=";

    public static String getUrl(String city){
        return baseUrl+city;
    }
}
