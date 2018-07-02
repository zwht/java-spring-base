package com.zw.common.vo.user;

public class LoginSuccessVo {

    private String id;
    private String name;
    private String token;
    private String type;
    private String roles;
    private String loginName;
    private String phone;
    private Long tokenEndTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getTokenEndTime() {
        return tokenEndTime;
    }

    public void setTokenEndTime(Long tokenEndTime) {
        this.tokenEndTime = tokenEndTime;
    }
}
