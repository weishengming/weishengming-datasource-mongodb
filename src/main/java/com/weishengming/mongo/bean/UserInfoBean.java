package com.weishengming.mongo.bean;

/**
 * Created by yangtianci on 2017/7/10.
 */
public class UserInfoBean {
    private String userId;
    private String userName;
    private String passwordMd5;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordMd5() {
        return passwordMd5;
    }

    public void setPasswordMd5(String passwordMd5) {
        this.passwordMd5 = passwordMd5;
    }
}
