package com.multiThread.state;

public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("******");
            }
        });
        // 线程创建完成，还没启动时的状态
        Thread.State state = t.getState();
        System.out.println(state);//NEW
        // 启动线程时的状态
        t.start();
        state = t.getState();
        System.out.println(state);//RUNNABLE
        //
        while (t.getState()!= Thread.State.TERMINATED){// 只要线程不终止就一直输出状态
            Thread.sleep(100);// TIMED_WAITING
            state = t.getState();
            System.out.println(state);
        }
    }
}
