package com.itheima.learn;

// 理解参数传递
public class MethodDemo2 {
    public static void main(String[] args) {
        //
        int a = 10;
        change(a);
        System.out.println(a);  //10

        System.out.println("--------------------");

        int[] arrs = new int[] {10, 20, 30};
        System.out.println(arrs);
        change2(arrs);
        System.out.println("main: " + arrs[1]); // 222  // 传递的是存储数组的地址
    }

    public static void change(int a) {
        System.out.println(a);  // 10
        a = 20;
        System.out.println(a);  // 20
    }

    public static void change2(int[] arrs) {
        System.out.println(arrs);
        System.out.println("方法内1： " + arrs[1]);
        arrs[1] = 222;
        System.out.println("方法内2： " + arrs[1]);
    }




}
