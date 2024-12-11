package com.itheima.learn;

// java学习案例，比较两个数组是否完全相等
public class MethodTest3 {
    public static void main(String[] args) {
        // int[] arr1和inr[] arr2
        int[] arr1 = {10,20,30,40,50,60,70,80,90};
        int[] arr2 = {1,2,3,4,5,6,7,8,9};
        System.out.println(equals(arr1,arr2));
    }

    public static boolean equals(int[] arr1, int[] arr2) {
        // 1.判断arr1和arr2是否都是null
        if (arr1 == null && arr2 == null) {
            return true;
        }

        // 2.判断arr1和arr2是否其中一个为null
        if (arr1 == null || arr2 == null) {
            return false;
        }

        // 3.判断长度是否相等
        if (arr1.length != arr2.length) {
            return false;
        }

        // 4.判断内容是否相等
        for (int i = 0; i < arr1.length; i++) {
            // 判断当前位置2个数组的元素是否一样，不一样直接返回false
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
