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

    /*
    一、访问修饰符：修饰符Private和public,
    public：表示公共的，可以在任何地方访问。
    protected：表示受保护的，可以在同一包内或子类中访问。
    private：表示私有的，只能在同一类内访问。
    默认（无修饰符）：表示包级私有的，只能在同一包内访问。
    */

    /*
    二、非访问修饰符
    1.final修饰符用于表示不可变的、不能被继承或修改的实体。在不同的场景中，final修饰符有不同的作用。
    final修饰类：表示该类不能被继承。
    final修饰方法：表示该方法不能被子类重写。
    final修饰变量：表示该变量的值不能被修改。

    2.static修饰符用于表示静态成员，即属于类本身而不是类的实例。静态成员在内存中只有一份副本，可以通过类名直接访问。
    static修饰变量：表示静态变量，可以在类的任何地方访问。
    static修饰方法：表示静态方法，可以在类的任何地方调用。
    static修饰代码块：表示静态代码块，在类加载时执行，用于初始化静态变量或执行其他静态操作。

    3.abstract修饰符
    abstract修饰类：表示抽象类，不能被实例化，只能作为其他类的基类。
    abstract修饰方法：表示抽象方法，只有声明而没有具体实现，需要子类进行实现。

    4.synchronized修饰符用于实现多线程同步，保证同一时间只有一个线程可以访问被修饰的代码块或方法。
     */
    // 封装的示例
    private double score;   // 隐藏

    // 通过下面公开的方法调用内部隐藏的数据，同时一个设置变量，一个获取变量
    public void setScore(double score) {
        if (score >=0 && score <= 100){
            this.score = score;
        }else {
            System.out.println("The score is invalid.");
        }
    }
    public double getScore() {
        return score;
    }
}

// 可以有多个类
class Phone {

}

