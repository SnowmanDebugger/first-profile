package com.Mrsmart.Array;

public class ArrayDemo01 {
    public static void main(String[] args) {
        int[] arrays = {1,2,3,4,5};

        //JDK1.5开始，没有下标
        for (int array : arrays) {
            System.out.println(array);
        }
    }
}
