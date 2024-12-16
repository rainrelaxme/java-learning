package com.itheima.obejct;

// 实体类JavaBean
public class Car {
    // 1.私有成员变量，并为每个变量提供set、get方法
    private String name;
    private String brand;
    private String Structure;

    // 2.必须为类提供一个公开的无参数构造器
    public Car() {
    }

    public Car(String make, String brand, String structure) {
        this.name = make;
        this.brand = brand;
        this.Structure = structure;
    }

    // idea右键“生成 -> getter and setter”快速生成
    public String getMake() {
        return name;
    }

    public void setMake(String make) {
        this.name = make;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStructure() {
        return Structure;
    }

    public void setStructure(String structure) {
        Structure = structure;
    }
}
