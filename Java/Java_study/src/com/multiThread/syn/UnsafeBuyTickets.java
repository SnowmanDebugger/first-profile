package com.multiThread.syn;

public class UnsafeBuyTickets {
    public static void main(String[] args) {
        BuyTickets station = new BuyTickets();

        new Thread(station,"Rob").start();
        new Thread(station,"Alex").start();
        new Thread(station,"Mike").start();
    }
}

class BuyTickets implements Runnable{

    private int ticketNums = 10;
    boolean flag = true;

    @Override
    public void run() {
        while (flag){
            try {
                buy();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private synchronized void buy() throws InterruptedException {
        if (ticketNums <= 0){
            flag = false;
            return;
        }

        //Thread.sleep(100);

        System.out.println(Thread.currentThread().getName()+"拿到了"+ticketNums--);
    }
}