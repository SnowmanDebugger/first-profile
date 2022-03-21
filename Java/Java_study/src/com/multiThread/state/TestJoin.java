package com.multiThread.state;

public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            if(i == 200){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("thread vip is coming "+ i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        //启动我们的线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 500; i++) {
            if(i == 200){
                thread.join();
            }
            System.out.println("main "+i);

        }
    }
}
