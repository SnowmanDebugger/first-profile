package com.oop.Demo2;

//一个项目应该只存在一个main方法
public class Application {
    public static void main(String[] args) {

        //类实例化后会返回一个自己的对象
        Student mike = new Student();

        /*
        mike.name = "mike";
        mike.age = 3;
        *
         */
        Person person = new Person();
        System.out.println(person.name);



    }
}
