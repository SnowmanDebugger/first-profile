package com.multiThread.Demo02;

public class StaticProxy {
    public static void main(String[] args) {

        new Thread( ()-> System.out.println("I love you!")).start();

        You you = new You();
        WeddingCompany weddingCompany = new WeddingCompany(you);
        weddingCompany.happyMarry();

        //new WeddingCompany(new You()).happyMarry();

    }
}
interface Marry{
    void happyMarry();
}

class You implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("I am getting married!!");
    }
}

class WeddingCompany implements Marry {

    private You target;

    public WeddingCompany (You target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        marryBefore();
        this.target.happyMarry();//真实对象
        marryAfter();
    }
    public void marryBefore(){
        System.out.println("Before getting married, set up the site");
    }

    public void marryAfter(){
        System.out.println("After getting married, retract the money");
    }
}
