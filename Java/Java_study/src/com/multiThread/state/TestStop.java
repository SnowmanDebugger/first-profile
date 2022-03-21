package com.multiThread.state;

public class TestStop implements Runnable {

    //设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i =0;
        while (flag){
            System.out.println("run....thread" + i++);
        }
    }

    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if(i == 900){
                //调用stop方法切换标志符停止线程
                testStop.stop();
                System.out.println("The thread is stopped");
            }
        }

    }
}
