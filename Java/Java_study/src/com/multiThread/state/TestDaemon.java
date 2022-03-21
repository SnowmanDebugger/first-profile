package com.multiThread.state;

public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);

        thread.start();//上帝线程启动

        new Thread(you).start();
    }
}


class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("God bless you");
        }
    }
}

class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("You have lived a happy life for " + i +"days");
        }
        System.out.println("====goodbye!world!====");
    }
}