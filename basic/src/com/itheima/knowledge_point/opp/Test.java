package com.itheima.knowledge_point.opp;

public class Test {
    public static void main(String[] args) {
        // 面向对象编程
        // 1. 创建一个学生对象，封装Jack的数据
        Student s1 = new Student();
        s1.name = "Jack";
        s1.age = 18;
        s1.chinese = 100;
        s1.english = 98;
        s1.averageScore();
        System.out.println(s1.averageScore());

        Student s2 = new Student();
        s2.english = 350;
        s2.printEnglishPass(250);
        s2.printEnglishPass(500);

        // 2. 认识构造器，new Student()实际是调用构造器，用于初始化赋值
        Student s3 = new Student();
        Student s4 = new Student("Shawn", 100);

        // 封装的隐藏、公开示例
        Student s5 = new Student();
        // s1.score = 100; 无法获取
        s1.setScore(89);
        System.out.println(s1.getScore());

        // 实体类&操作类的示例
        Car c1 = new Car();
        c1.setBrand("Toyota");
        c1.setStructure("1 steering wheel, 4 wheels");
        CarOperator operator = new CarOperator(c1);
        operator.drive();

        Car c2 = new Car("done", "BYD", null);
        CarOperator operator2 = new CarOperator(c2);
        operator2.drive();

    }
}
