package com.zw.cf.vo;

import org.springframework.beans.BeanUtils;

/**
 * Created by zhaowei on 2017/9/18.
 */
public class ResetPasswordVo{

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    private String oldPwd;
    private String newPwd;
}
