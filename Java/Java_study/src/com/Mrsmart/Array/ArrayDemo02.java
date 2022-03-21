package com.Mrsmart.Array;

public class ArrayDemo02 {
    public static void main(String[] args) {
        int[] arrays = {44,22,55,11,77};

        sort(arrays);
        printarray(arrays);
    }

    public static void sort(int[] array){
        int temp = 0;

        for(int i = 0;i < array.length-1;i++){
            boolean flag = true;
            for(int j = 0; j < array.length-1-i; j++){
                if (array[j+1] < array[j]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }

    public static void printarray(int[] array){
        for (int x : array) {
            System.out.println(x);
        }
    }
}

