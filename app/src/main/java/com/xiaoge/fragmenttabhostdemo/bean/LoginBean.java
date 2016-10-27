package com.xiaoge.fragmenttabhostdemo.bean;

import java.io.Serializable;

/**
 * Created by LvYou on 2016/10/26 0026.
 */

public class LoginBean implements Serializable{

    /**
     * code : 0
     * msg : 登录成功
     * data : {"id":"1","name":"zhangsan","password":"123456"}
     */

    public int code;
    public String msg;
    /**
     * id : 1
     * name : zhangsan
     * password : 123456
     */

    public DataBean data;

    public static class DataBean {
        public int id;
        public String name;
        public String password;
    }
}

