package com.multiThread.Demo01;

public class TestThread01 extends Thread{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("代码----" + i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程

        //创建一个线程对象
        TestThread01 testThread01 = new TestThread01();

        //调用start()方法开启线程
        testThread01.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("学习----" + i);
        }

    }
}
