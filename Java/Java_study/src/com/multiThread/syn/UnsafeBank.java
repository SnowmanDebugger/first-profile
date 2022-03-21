package com.multiThread.syn;

public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100,"marriage fund");

        Drawing alex = new Drawing(account,50,"Alex");
        Drawing rose = new Drawing(account,100,"Rose");

        alex.start();
        rose.start();

    }
}

class Account{
    int balance;
    String name;

    public Account(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }
}

class Drawing extends Thread{

    Account account;
    int drawingMoney;
    int nonMoney;

    @Override
    public void run() {
        //锁的对象是变化的量，需要增删改的量
        synchronized (account){
            if (account.balance - drawingMoney < 0){
                System.out.println(Thread.currentThread().getName()+" the balance is not enough");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.balance -= drawingMoney;
            nonMoney += drawingMoney;
            System.out.println(account.name+" has the balance of "+account.balance);
            //this.getName() == Thread.currentThread().getName()
            System.out.println(this.getName()+" money in hand "+ nonMoney);
        }
    }

    public Drawing(Account account, int drawingMoney, String name){
        super(name);
        this.account=account;
        this.drawingMoney=drawingMoney;
    }


}


