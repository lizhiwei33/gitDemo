package com.app.xinan.gitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.app.xinan.gitdemo.entity.Photo;
import com.app.xinan.gitdemo.net.MyNet;
import com.app.xinan.gitdemo.net.Observe;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;

public class ImageShowActivity extends AppCompatActivity {
    private static final String TAG = "ImageShowActivity";
    private ImageView ivShow;
    private BitmapUtils bUtils;
    private String imgUrl="https://www.baidu.com/img/bd_logo1.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_show);
        initView();
        getData();

    }

    private void initView() {
        ivShow = (ImageView) findViewById(R.id.ivShow);
         bUtils =new BitmapUtils(this);//实例化我们的工具类

    }

    private void getData(){
        String url = "https://www.apiopen.top/meituApi?page=1";
        MyNet.requestGet(this, url, new Observe() {
            @Override
            public void onSuccess(String response) {
                Gson gson = new Gson();
                Photo photo = gson.fromJson(response,Photo.class);
                Photo.Data data = photo.getList().get(0);
               final String imageUrl = data.getUrl();
                Log.d(TAG, "onSuccess: "+imageUrl);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        bUtils.display(ivShow,imgUrl);//调用显示图片的方法
                    }
                });

            }

            @Override
            public void onError(VolleyError ve) {

            }
        });
    }
    /**
     * 根据路径显示想要的图片
     */
    private void display(String url) {
        //图片显示：xUtils
        //步骤
    }



}
