package com.itheima.learn;

public class MethodOverloadDemo1 {
    public static void main(String[] args) {
        // 方法重载，只看方法名称相同和形参不同

    }

    public static void testOverload() {
        System.out.println("testOverload");
    }

    public static void testOverload(int a) {
        // 形参不同
        System.out.println("testOverload2");
    }

    void testOverload(double a) {
        // 形参类型不同
        System.out.println("testOverload3");
    }

    void testOverload(double a, int b) {
        System.out.println("testOverload4");
    }

    void testOverload(int a, int b) {
        System.out.println("testOverload5");
    }

    void testOverload(int a, int b, int c) {
        System.out.println("testOverload6");
    }
}
