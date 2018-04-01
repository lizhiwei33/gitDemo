package com.app.xinan.gitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.app.xinan.gitdemo.net.AppUrl;
import com.app.xinan.gitdemo.net.MyNet;
import com.app.xinan.gitdemo.net.Observe;
import com.app.xinan.gitdemo.net.ParseData;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button bt;
    private TextView tvShow;
    private EditText editCity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiview();//初始化控件
    }

    /*初始化方法*/
    private void intiview() {
        tvShow = (TextView) findViewById(R.id.textShow);
        editCity = (EditText) findViewById(R.id.cityEdit);

        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();//获取接口数据
            }
        });
    }

    private void getData() {
        //获取用户输入框的值
        String city = editCity.getText().toString().trim();
        // String url= AppUrl.getUrl(city);//获取我们的接口url
        MyNet.requestGet(this, AppUrl.getUrl(city), new Observe() {
            @Override
            public void onSuccess(String response) {
                Log.d(TAG, "onSuccess: "+response);
                //解析基本数据类型（封装）
                String date = ParseData.parseString(response,"date");
                String message = ParseData.parseString(response,"msssage");
                int status = ParseData.parseInt(response,"status");

                //解析对象中的对象属性
                JSONObject data = ParseData.parseObject(response,"data");
                String shudu =   data.optString("shidu");
                String quality =  data.optString("quality");
                //解析对象中数组对象
                JSONArray  array = ParseData.parseObjectArray(data,"forecast");
                String high =   array.optJSONObject(0).optString("high");

                /*JsonObject：格式：{
                    "person":[
                    {"name":"lizhiwei",
                                "age":  18},{"name":"lizhiwei",
                            "age":  18};{"name":"lizhiwei",
                            "age":  18};{"name":"lizhiwei",
                            "age":  18};
                            ]
                    {
                }*/

               // 解析数据：
            /*    try {
                    JSONObject object = new JSONObject(response);
                    final   String errMsg = object.getString("errMsg");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvShow.setText(errMsg);
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }*/
            }

            @Override
            public void onError(VolleyError ve) {
                Log.d(TAG, "onError: "+ve.toString());
            }
        });
    }












   /* *//**
     * getData :获取数据的方法
     * 注意：别忘记配置网络权限
     *//*
    private void getData() {
        //1.定义url:http://apis.baidu.com/apistore/dhc/getallrule?user=34ccd43b88617e1c8888856ea5d7f44c
        String url = "http://apis.baidu.com/apistore/dhc/getallrule?user=34ccd43b88617e1c8888856ea5d7f44c";
        //2.创建一个请求队列的对象
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //3.以什么方式进行网络请求:get post;
        //参数：get、post：请求方式；url：请求地址；Listener：请求成功回调事件；ErrorListener：请求是失败回调方法
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse:"+response);
                //5.解析数据：
                try {
                    JSONObject object = new JSONObject(response);
                    final   String errMsg = object.getString("errMsg");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvShow.setText(errMsg);
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d(TAG, "onErrorResponse: "+volleyError.toString());
            }
        });
        //4.将我们的请求放入到我们的队列中
        requestQueue.add(stringRequest);
        requestQueue.start();
    }*/
}