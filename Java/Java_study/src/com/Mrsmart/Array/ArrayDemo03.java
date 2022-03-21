package com.Mrsmart.Array;

public class ArrayDemo03 {
    public static void main(String[] args) {
        int[][] array1 = new int[11][11];
        array1[1][2] = 1;
        array1[2][3] = 2;
        array1[7][7] = 3;
        //输出原始数组,并求和
        System.out.println("输出原始数组：");

        int sum = 0;
        for (int[] ints : array1) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
                if (anInt != 0){
                    sum += 1;
                }
            }
            System.out.println();
        }

        System.out.println("============================");

        //输出稀疏数组
        //填充稀疏数组第一列
        int[][] array2 = new int [sum+1][3];
        array2[0][0] = array1.length;
        array2[0][1] = array1[0].length;
        array2[0][2] = sum;

        //填充稀疏数组主体
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                if (array1[i][j] != 0){
                    count++;
                    array2[count][0] = i;
                    array2[count][1] = j;
                    array2[count][2] = array1[i][j];
                }
            }
        }

        //打印稀疏数组
        System.out.println("稀疏数组是：");
        for (int[] ints : array2) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }

        System.out.println("============================");

        //还原稀疏数组
        int[][] array3 = new int[array2[0][0]][array2[0][1]];

        for (int i = 1; i < array2.length; i++) {
            array3[array2[i][0]][array2[i][1]] = array2[i][2];
        }

        //打印还原数组
        System.out.println("还原数组为：");

        for (int[] ints : array3) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
    }
}
