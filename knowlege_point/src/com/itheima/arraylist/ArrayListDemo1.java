package com.itheima.arraylist;

import java.util.ArrayList;

/*
目标:要求同学们掌握如何创建ArrayList集合的对象，并熟悉ArrayList提供的常用方法。
 */
public class ArrayListDemo1 {
    public static void main(String[] args) {
        // 1.创建一个ArrayList的集合对象
        // <>中限制类型，可填可不填
        // ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<>();
        list.add("shawn");
//        list.add(999);  // 类型被限制了。
        list.add("love");
        list.add("you");
        System.out.println(list);

        // 2.往集合中某个索引位置添加数据
        list.add(2, "very");

        // 3.get()
        System.out.println(list.get(1));

        // 4. size()
        System.out.println(list.size());

        // 5.根据索引删除
        System.out.println(list.remove(0));
        System.out.println(list);

        // 6.直接删除内容，默认只删除第一个
        System.out.println(list.remove("very"));
        System.out.println(list);

        // 7.修改某个索引位置处的数据，修改后会返回原来的值给我们
        System.out.println(list.set(1, "Ni"));
        System.out.println(list);

    }
}
