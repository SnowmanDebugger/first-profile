package com.Mrsmart.structure;

public class ForDemo01 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                int acc = i*j;
                System.out.print(j+"*"+i+"="+acc+"   ");
            }
            System.out.println();
        }
    }

}

