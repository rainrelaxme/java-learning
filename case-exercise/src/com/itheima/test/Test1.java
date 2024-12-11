package com.itheima.test;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the price of the airplane: ");
        double price = sc.nextDouble();
        System.out.println("Please enter the current month: ");
        int month = sc.nextInt();
        System.out.println("Please enter the seat level of  the airplane: ");
        String seat = sc.next();

        double newPrice = discountPrice(price, month, seat);
        System.out.println("New price is: " + newPrice);

    }

    public  static double discountPrice(double price, int month, String seatLevel) {
        /*
            用户购买机票时，机票原价会按照淡季、旺季，头等舱还是经济舱的情况进行相应的优惠，优惠方案如下:5-10月为旺季，头等舱9折，经济舱8.5折;11月到来年4月为淡季，头等舱7折，经济舱6.5折，请开发程序计算出用户当前机票的优惠价。
        */
        double discount = 0;
        if (month > 12 || month < 1) {
            System.out.println("Please enter a valid month");
            return discount;
        }

        if ( month >= 5 && month <=10) {
            switch (seatLevel) {
                case "经济舱":
                    // 经济舱
                    discount = price * 0.85;
                    break;
                case "头等舱":
                    // 头等舱
                    discount = price * 0.9;
                    break;
                default:
                    System.out.println("Invalid seat level");
                    discount = price;
                    break;
            }
        }
        else {
            switch (seatLevel) {
                case "经济舱":
                    // 经济舱
                    discount = price * 0.65;
                    break;
                case "头等舱":
                    // 头等舱
                    discount = price * 0.7;
                    break;
                default:
                    System.out.println("Invalid seat level");
                    discount = price;
                    break;
            };

        }
        return discount;
    }


}


