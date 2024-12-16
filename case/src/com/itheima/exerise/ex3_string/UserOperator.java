package com.itheima.exerise.ex3_string;

public class UserOperator {
    private User user;

    public UserOperator(User user) {
        this.user = user;
    }

    // 获取用户信息
    public void printUserInfo() {
        System.out.println("I am " + user.getName() + ". ");
    }

    // 用户登录
    public int login(String loginName, String password, int errorTimes) {
        if(errorTimes < 3) {
            if (user.getLoginName().equals(loginName)) {
                if (user.getPassword().equals(password)) {
                    System.out.println("欢迎进入系统!");
                    return 0;
                }else {
                    System.out.println("Wrong password.");
                    return 1;
                }
            }else {
                System.out.println("Wrong login name.");
                return 1;
            }
        }else {
            System.out.println("错误次数超上限");
            return 2;
        }
    }
}
