package com.itheima.learn;

public class MethodDemo1 {
    public static void main(String[] args) {

        // 方法打印多行helloworld
        printHelloWorld1();

        System.out.println("----------------------");

        printHelloWorld2( 4);

        System.out.println("----------------------");

        System.out.println(printHelloWorld3(2));
    }

    /**
     无返回值使用void
     有返回值则对应响应数据类型
     */
    public static void printHelloWorld1() {
        // 无参数
        for (int i =1; i<=3; i++) {
            System.out.println("Hello World!");
        }
    }

    public static void printHelloWorld2(int n) {
        // 无参数
        for (int i =1; i<=n; i++) {
            System.out.println("Hello World!");
        }
    }

    // 有返回值
    public static String printHelloWorld3(int n) {
        // 有返回值
        String text = "";
        for (int i =1; i<=n; i++) {
            text = text + "Hello World!\n";
        }
        return text;
    }
}
