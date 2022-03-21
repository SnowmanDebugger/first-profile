package com.multiThread.syn;

public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0,"Rose");
        Makeup g2 = new Makeup(1,"Beth");

        g1.start();
        g2.start();
    }
}

class Lipstick{

}

class Mirror{

}

class Makeup extends Thread{
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;

    Makeup(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeUp() throws InterruptedException {
        if (choice == 0){
            synchronized (lipstick){
                System.out.println(this.girlName + "get the lipstick lock");
                Thread.sleep(1000);
                synchronized (mirror){
                    System.out.println(this.girlName + "get the mirror lock");
                }
            }
        }
        else{
            synchronized (mirror){
                System.out.println(this.girlName + "get the mirror lock");
                Thread.sleep(2000);
                synchronized (lipstick){
                    System.out.println(this.girlName + "get the lipstick lock");
                }
            }
        }
    }
}