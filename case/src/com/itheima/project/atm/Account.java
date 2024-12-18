package com.itheima.project.atm;

public class Account {
    // 参数

    private int accountID;
    private String name;
    private String sex;
    private String accountCode;
    private String password;
    private double money;
    private int accountLevel;

    // 构造器
    public Account() {

    }

    public Account(String name, String sex, int accountID, String accountCode, String password, double money, int accountLevel) {
        this.name = name;
        this.sex = sex;
        this.accountID = accountID;
        this.accountCode = accountCode;
        this.password = password;
        this.money = money;
        this.accountLevel = accountLevel;
    }

    // generator set$get

    public String getName() {
        return name + (sex.equals("男") ? "先生":"女士");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
            this.sex = sex;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {

            this.accountID = accountID;

    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(int accountLevel) {
        this.accountLevel = accountLevel;
    }
}
