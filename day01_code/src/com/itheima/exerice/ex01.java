package com.itheima.exerice;

public class ex01 {
    public static void main(String[] args) {
        int[] saleMoney = {16, 26, 36, 6, 100};
        int sum = 0;
        for (int i=0; i < saleMoney.length; i++) {
            sum = sum + saleMoney[i];
        }
        System.out.println(sum);
    }
}
