package com.exception;

public class Demo03 {
    public static void main(String[] args) {

        try {
            new Demo03().test(1,0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    public void test(int a,int b) throws ArithmeticException{
        if (b == 0){
            throw new ArithmeticException();
        }
    }
}
