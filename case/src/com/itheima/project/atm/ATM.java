package com.itheima.project.atm;

import java.util.*;

public class ATM {

    private static ArrayList<Account> accounts = new ArrayList<>();    // []

    private static Scanner sc = new Scanner(System.in);    // 封装只给ATM自己用

    // 欢迎页
    public void start() {
        // 启动atm
        System.out.println("===欢迎进入福泽银行ATM系统===");
        System.out.println("1.用户登录");
        System.out.println("2.用户开户");
        System.out.println("3.查询单个账户");
        System.out.println("4.查询所有账户");
        System.out.println("# 退出");
        System.out.println("请选择您要操作的命令： ");
        String choice = sc.next();
        switch (choice) {
            case "1":
                // 用户登录
                System.out.println("你选择1");
                this.start();
                break;
            case "2":
                // 用户开户
                createAccount();
                this.start();
                break;
            case "3":
                // 查询单个账户
                this.start();
                break;
            case "4":
                // 查询所有账户
                getAllAccount();
                this.start();
                break;
            case "#":
                // 退出系统
                System.out.println("退出成功！");
                break;
            default:
                System.out.println("错误的指令，请重新选择");
                this.start();
                break;
        }

    }

    // 开户
    private static void createAccount() {
        System.out.println("==系统开户中==");
        // 创建一个账户对象，用于封装用户信息。
        Account account = new Account();

        // 为账户对象添加信息
        System.out.println("请输入您的姓名： ");
        String name = sc.next();
        account.setName(name);

        while (true) {
            System.out.println("请输入您的性别： ");
            String sex = sc.next();
            if (sex.equals("男") || sex.equals("1")) {
                account.setSex("男");
                break; // 循环一定要能跳出
            }else if (sex.equals("女") || sex.equals("2")) {
                account.setSex("女");
                break;
            }else {
                System.out.println("错误的性别，请重新输入： ");
            }
        }

        while (true) {
            System.out.println("请输入您的账户密码： ");
            String password = sc.next();
            System.out.println("请再次输入您的账户密码： ");
            String password2 = sc.next();
            if (password.equals(password2)) {
                account.setPassword(password);
                break;
            } else {
                System.out.println("您输入的两次密码不一致，请再次尝试~~");
            }
        }

        // 生成ID,自增：1，2，3。。。
        int newAccountId = createAccountID();
        account.setAccountID(newAccountId);

        // 生成卡号
        String newAccountCode =  createAccountCode();
        account.setAccountCode(newAccountCode);

        // 账户生成成功，存储到集合中。
        accounts.add(account);
        System.out.println("恭喜您，" + account.getName() + "您的账户已开通，帐号为： " + account.getAccountCode() + "!");
    }

    // 查询所有账户信息卡号及名称
    private void getAllAccount() {
        if (accounts.isEmpty()) {
            System.out.println("无账户，银行要倒闭了~~");
        }else {
            for (Account account : accounts) {
                System.out.println(account.getAccountID() + ":" + account.getName() + ":" + account.getAccountCode());
            }
        }
    }

    // 返回一个不固定长度的账户ID，且系统自增
    private static int createAccountID() {
        int maxAccID = 0;
        // 根据当前ID最大，再加一；
        if (accounts.isEmpty()) {
            return 1;
        }else {
            // 查找ID最大值
            for (Account account : accounts) {
                if (account.getAccountID() > maxAccID) {
                    maxAccID = account.getAccountID();
                }
            }
            return maxAccID + 1;
        }
    }

    // 返回一个8位数的卡号，且不能与其他卡号重复
    private static String createAccountCode() {
        while (true) {
            String cardID = "";
            Random r = new Random();
            for (int i = 0; i < 8; i++) {
                cardID += r.nextInt(10); // 0-9
            }
            // 判断是否与其他卡号重复
            Account acc = getAccountByAccountCode(cardID);
            if (acc == null) {
                // 没找到，可以做新卡号
                return cardID;
            }
        }
    }

    // 根据卡号查询是否已存在此卡号,返回类型是账户对象
    private static Account getAccountByAccountCode(String accountCode) {
        // 复杂写法
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            // 判断这个卡号是否是我们要找的卡号
            if (account.getAccountCode().equals(accountCode)) {
                return account;
            }
        }
            return null;

        /* 简单写法
        for (Account account : accounts) {
            // 判断这个卡号是否是我们要找的卡号
            if (account.getAccountCode().equals(accountCode)) {
                return account;
            }
        }
         */
    }

    public void login(int accountID, String password) {

    }
}
