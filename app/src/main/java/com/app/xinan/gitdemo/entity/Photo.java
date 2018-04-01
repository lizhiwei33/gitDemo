package com.app.xinan.gitdemo.entity;

import java.util.List;

/**
 * Created by lzw on 2018/4/1.
 */
/*
*"code": 200,
	"msg": "成功!",
	"data": [{
		"createdAt": "2017-11-23T08:32:29.546Z",
		"publishedAt": "2017-11-24T11:08:03.624Z",
		"type": "美图",
		"url":
* */
public class Photo {;

    String msg;
    List<Data> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Data> getList() {
        return data;
    }

    public void setList(List<Data> data) {
        this.data = data;
    }
    public class Data{
        String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
