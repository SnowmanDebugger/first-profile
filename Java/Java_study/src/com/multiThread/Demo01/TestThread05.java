package com.multiThread.Demo01;

//抢火车票的例子
//发现问题：(不同的人拿到了同一张票)多个线程同时操作同一个资源时，数据不安全，出现紊乱
public class TestThread05 implements Runnable {
    private int ticketNums = 10;

    @Override
    public void run() {

        while (true){
            if (ticketNums<=0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->拿到了第" + ticketNums-- +"张票");
        }
    }

    public static void main(String[] args) {
        TestThread05 test05 = new TestThread05();

        new Thread(test05,"Mike").start();
        new Thread(test05,"Alex").start();
        new Thread(test05,"Rob").start();

    }
}
