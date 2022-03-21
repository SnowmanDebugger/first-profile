package com.exception;

public class Demo01 {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;

        try {
            System.out.println(a/b);
        }catch (ArithmeticException e){
            System.out.println("程序出现异常,变量b不能为0");
        }finally {
            System.out.println("finally");
        }
    }
}
