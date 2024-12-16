package com.itheima.test.ex3_string;

public class User {
    private String name;
    private String loginName;
    private String password;

    public User() {
    }

    public User(String name, String loginName, String password) {
        this.name = name;
        this.loginName = loginName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
