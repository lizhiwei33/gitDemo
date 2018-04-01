package com.app.xinan.gitdemo.entity;

/**
 * Created by lzw on 2018/4/1.
 */
/*
* {"status":200,"message":"success","data":{"year":2018,"month":4,"day":1,
* "lunarYear":2018,"lunarMonth":2,"lunarDay":16,"cnyear":"贰零壹捌 ",
* "cnmonth":"二","cnday":"十六","hyear":"戊戌","cyclicalYear":"戊戌",
* "cyclicalMonth":"乙卯","cyclicalDay":"癸亥","suit":"祭祀,开光,塑绘,订盟,纳采,
* 合帐,冠笄,拆卸,动土,起基,上梁,入宅,安香,开市,立券,纳财,沐浴,求嗣,出火,竖柱,安门",
* "taboo":"造庙,嫁娶,伐木,安葬","animal":"狗","week":"Sunday",
* "festivalList":["愚人节"],"jieqi":{"5":"清明","20":"谷雨"},
* "maxDayInMonth":30,"leap":false,"lunarYearString":"戊戌","bigMonth":true}}
* */
public class NongLi {
    private String message;
    private Data data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data{
        private String suit;
        private String cnyear;
        private JieQi jieqi;


        public String getSuit() {
            return suit;
        }

        public void setSuit(String suit) {
            this.suit = suit;
        }

        public String getCnyear() {
            return cnyear;
        }

        public void setCnyear(String cnyear) {
            this.cnyear = cnyear;
        }
    }
    public class JieQi{
        private String lunarYearString;

        public String getLunarYearString() {
            return lunarYearString;
        }

        public void setLunarYearString(String lunarYearString) {
            this.lunarYearString = lunarYearString;
        }
    }
}
