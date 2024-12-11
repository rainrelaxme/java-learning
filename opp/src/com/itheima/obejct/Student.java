package com.itheima.obejct;

// 允许有多个class，但只能有一个public,且public的类名必须为文件名
public class Student {


    // 成员变量（对象的属性）
    String name;    // 默认值null
    int age;    // 默认值0
    double chinese; // 默认值0.0
    double english;

    /*
    类在设计时，如果不写构造器，Java 是会为类自动生成一个无参构造器的。
    一旦定义了有参数构造器，Java 就不会帮我们的类自动生成无参构造器了，此时就建议自己手写一个无参数构造器出来了。
    */
    // 无参数构造器
    public  Student() {
        System.out.println("构造器1");
    }

    // 有参数构造器
    public  Student(String name, double score) {
        System.out.println("构造器2"+name);
    }

    // 成员方法（对象的行为）
    public void printInfo() {
        System.out.println(name + "is " + age + " years old.");
    }

    public double totalScore() {
        return chinese + english;
    }

    public  double averageScore() {
        return (chinese + english) / 2;
    }

    public void printEnglishPass(double english) {
        //  if (english > english)
        // 用this调用对象本身的属性。
        if (this.english > english) {
            System.out.println("The english score pass");
        }
        else {
            System.out.println("The english score is failed.");
        }
    }
}

class Phone {

}

class Car {

}