package com.itheima.exerise.ex2_opp;

import java.util.Scanner;
import com.itheima.exerise.ex1_airplanePrice.Test1;

public class Test {
    public static void main(String[] args) {
        Movie[] movies = new Movie[3];
        movies[0] = new Movie("001", "水门桥", 38.9);
        movies[1] = new Movie("002", "出拳吧，妈妈", 38.9);
        movies[2] = new Movie("003", "战狼", 59.9);

        // 包的引用
        // 同一个包的直接饮用
        Movie movie1 = new Movie();
        // 不同包的要先导入
        double newPrice2 = Test1.discountPrice(100, 10, "头等舱");

        MovieOperator showMovie = new MovieOperator(movies);
        showMovie.printAllMovies();
        showMovie.searchMovieById("001");

        Scanner sc = new Scanner(System.in);
//        sc.hasNextInt()
        while (true) {
            System.out.println("==电影信息系统==");
            System.out.println("1.查询全部电影信息");
            System.out.println("2.根据id查询某个电影的详细信息展示");
            System.out.println("999.退出");
            System.out.println("请您输入操作命令: ");

            String choice = sc.next();
            switch (choice) {
                case "1":
                    showMovie.printAllMovies();
                    break;
                case "2":
                    System.out.println("请输入查询电影的id： ");
                    String id = sc.next();
                    showMovie.searchMovieById(id);
                    break;
                case "999":
                    System.out.println("已退出！");
                    return;
                default:
                    System.out.println("输入指令有误！");
                    break;
            }
        }
    }
}
