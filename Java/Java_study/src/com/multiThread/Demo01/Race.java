package com.multiThread.Demo01;

public class Race implements Runnable{

    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (Thread.currentThread().getName().equals("rabbit")  && i % 10 == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = gameOver(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了第" + i + "步");
        }

    }

    public boolean gameOver(int step){
        if (winner != null){
            return true;
        }{
            if (step >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("Winner is the " + Thread.currentThread().getName());
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"rabbit").start();
        new Thread(race,"turtle").start();

    }
}
