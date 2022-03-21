package com.multiThread.Demo01;

//实现runnable接口，重写run()方法，执行线程需要丢入的runnable接口实现类，调用start方法开启线程
public class TestThread03 implements Runnable{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("代码----" + i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程

        //创建runnable接口的实现类对象
        TestThread03 testThread03 = new TestThread03();

        //创建线程对象，通过线程对象来开启线程（把自定义的对象当参数传入Tread对象）,代理
        /*
        Thread thread = new Thread(testThread03);
        thread.start();
        **/
        new Thread(testThread03).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("学习----" + i);
        }
    }
}
  