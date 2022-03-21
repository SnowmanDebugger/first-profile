package com.multiThread.syn;

public class UndoDeadLock {
    public static void main(String[] args) {
        UnMakeup g1 = new UnMakeup(0,"Rose");
        UnMakeup g2 = new UnMakeup(1,"Beth");

        g1.start();
        g2.start();
    }
}


class UnMakeup extends Thread{
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;

    UnMakeup(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            unMakeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void unMakeUp() throws InterruptedException {
        if (choice == 0){
            synchronized (lipstick){
                System.out.println(this.girlName + "get the lipstick lock");
                Thread.sleep(1000);
            }
            synchronized (mirror) {
                System.out.println(this.girlName + "get the mirror lock");
            }
        } else{
            synchronized (mirror){
                System.out.println(this.girlName + "get the mirror lock");
                Thread.sleep(2000);
            }
            synchronized (lipstick){
                System.out.println(this.girlName + "get the lipstick lock");
            }
        }
    }
}

