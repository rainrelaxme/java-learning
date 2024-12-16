package com.itheima.exerice;
import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {
        //6评委评分平均值
        double[] scores = new double[6];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            System.out.println("Please " + (i+1) + " input your score for player:");
            double score = sc.nextDouble();
            scores[i] = score;
        }

        double sum = 0;
        double avg = 0;
        for (int i = 0; i < scores.length; i++){
            sum += scores[i];
        }
        avg = sum/scores.length;
        System.out.println("Your score is " + avg);
    }
}
