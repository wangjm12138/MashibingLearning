package com.jackiewang.algorithm.Sort;

public class HeapSort {


    private static void heapInsert(int[] arryay, int index){
        while(index > 0 && arryay[index] > arryay[(index-1)/2]){
            swap(arryay, index, index/2);
            index = (index-1)/2;
        }
    }



    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {

    }
}
