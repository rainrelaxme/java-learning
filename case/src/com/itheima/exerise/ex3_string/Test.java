package com.itheima.exerise.ex3_string;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
     /*
     系统正确的登录名和密码是， itheima/123456, 请在控制台开发一个登录界面，接收用户输入的登录名和密码，判断用户是否登录成功，登录成功后展示："欢迎进入系统！"/即可停止程序（注意：要求最多给用户三次登录机会）
    */
        User newUser = new User("Shawn", "20111764", "shawn-password");

        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            System.out.println("==系统登录==");
            System.out.println("用户名： ");
            String loginName = sc.nextLine();
            System.out.println("密码：");
            String password = sc.nextLine();

            UserOperator newUserOperator = new UserOperator(newUser);
            newUserOperator.login(loginName, password,i);
        }




    }
}
