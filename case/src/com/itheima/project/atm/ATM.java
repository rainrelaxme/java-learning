package com.itheima.project.atm;

import java.util.Scanner;

public class ATM {
    Scanner sc = new Scanner(System.in);

    // 欢迎页
    public void start() {
        // 启动atm
        System.out.println("===欢迎进入黑马银行ATM系统===");
        System.out.println("1.用户登录");
        System.out.println("2.用户开户");
        System.out.println("# 退出");
        System.out.println("请选择您要操作的命令： ");
        String choice = sc.next();
        switch (choice) {
            case "1":
                System.out.println("你选择1");
                break;
            case "2":
                System.out.println("你选择了2");
                break;
            case "#":
                System.out.println("退出成功！");
                break;
            default:
                System.out.println("错误的指令，请重新选择");
                this.start();
                break;
        }
    }

    public void login(int accountID, String password) {

    }
}
