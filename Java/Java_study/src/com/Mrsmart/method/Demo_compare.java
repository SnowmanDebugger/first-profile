package com.Mrsmart.method;

public class Demo_compare {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        short c = 10;
        short d = 20;
        int e = 10;
        int f = 10;
        long g = 10;
        long h = 20;
        // 调用
        System.out.println(compare(a, b));
        System.out.println(compare(c, d));
        System.out.println(compare(e, f));
        System.out.println(compare(g, h));
    }
    public static boolean compare(byte a,byte b){
        System.out.println("byte");
        return a == b;
    }
    public static boolean compare(int a,int b){
        System.out.println("int");
        return a == b;
    }
    public static boolean compare(long a,long b){
        System.out.println("long");
        return a == b;
    }
    public static boolean compare(short a,short b){
        System.out.println("short");
        return a == b;
    }

}
