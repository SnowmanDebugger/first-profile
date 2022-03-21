package com.oop.Demo06;

public class Application {
    public static void main(String[] args) {
        Outer outer = new Outer();

        Outer.Inner inner = outer.new Inner();
        inner.in();
    }
}
