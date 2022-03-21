package com.multiThread.Demo03;

public class TestLambda2 {
    public static void main(String[] args) {
        ILove love = new ILove() {
            @Override
            public void love(int i) {
                System.out.println("I love U--->" + i);
            }
        };
        love.love(2);
    }
}

interface ILove {
    void love(int i);
}