package com.itheima.exerise.ex2_opp;

// exercise: 面向对象，模仿电影信息系统
// 实体类
public class Movie {

    private String id;
    private String name;
    private double price;

    public Movie() {
    }

    public Movie(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
