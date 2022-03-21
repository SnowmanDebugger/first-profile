package com.oop.Demo04;

public class Student extends Person {
    private String name = "Rob";

    public void test(String name){
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
    }

}
