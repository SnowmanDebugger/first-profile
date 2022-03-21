package com.multiThread.Demo03;

public class TestLambda3 {
    public static void main(String[] args) {
        ILove love = (int i)->{
            System.out.println("I love you-->" + i);
        };

        //简化1.去掉参数类型
        love = (i)->{
            System.out.println("I love you-->" + i);
        };

        //简化2.简化括号
        love = i -> {
            System.out.println("I love you-->" + i);
        };

        //简化3.去掉花括号
        //(ILove love = null;)
        love = i -> System.out.println("I love you-->" + i);


        love.love(522);
    }
}
