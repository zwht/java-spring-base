package com.zw.common.vo.user;

import java.util.Date;

/**
 * Created by zhaowei on 2018/7/1.
 */
public class TokenVo {


    private String loginName;
    private String id;
    private Date endTime;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}