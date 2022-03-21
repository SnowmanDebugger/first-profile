package com.Mrsmart.scanner;

import java.util.Scanner;

public class scanner_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("使用next方式接收：");

        //判断用户有没有输入字符串
        if (scanner.hasNext()){
            String str = scanner.next();
            System.out.println("输出内容为："+str);
        }

        scanner.close();

    }
}
