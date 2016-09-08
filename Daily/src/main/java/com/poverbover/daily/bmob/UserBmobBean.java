package com.poverbover.daily.bmob;

import cn.bmob.v3.BmobObject;

/**
 * Created by void on 2016/9/8.
 */
public class UserBmobBean extends BmobObject{
    private String userName;
    private String passWord;
    private String nickName;
    private String adavterUrl;

    public UserBmobBean(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAdavterUrl() {
        return adavterUrl;
    }

    public void setAdavterUrl(String adavterUrl) {
        this.adavterUrl = adavterUrl;
    }
}
