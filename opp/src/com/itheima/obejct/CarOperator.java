package com.itheima.obejct;

public class CarOperator {
    private Car car;    // 私有连接car的实体类

    // 将通过构造器传入的数据，传递给操作类
    public CarOperator(Car car) {
        this.car = car;
    }

    // 操作的具体方法
    public void drive() {
        System.out.println("I'm driving a car. It's " + car.getBrand() + "'s car.\nAnd it have " + car.getStructure() + ".");
    }

}
