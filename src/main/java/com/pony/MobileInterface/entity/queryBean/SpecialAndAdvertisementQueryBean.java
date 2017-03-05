package com.pony.MobileInterface.entity.queryBean;

import lombok.experimental.Accessors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangmingyue on 2017/3/1 0001.
 * 广告或专题查询条件类
 */
@Accessors(chain = true)
public class SpecialAndAdvertisementQueryBean {
    //按当前时间查询有效广告或专题 日期格式2011-09-20 08:30:45
    private String currentTime;
    private int specialId;

    //setter and getter

    public int getSpecialId() {
        return specialId;
    }

    public void setSpecialId(int specialId) {
        this.specialId = specialId;
    }

    public String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        currentTime = dateFormat.format(new Date());
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }


}
