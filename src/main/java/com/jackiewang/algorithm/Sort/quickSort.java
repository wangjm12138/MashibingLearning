package com.jackiewang.algorithm.Sort;

public class quickSort {

    public static int[] subSort(int[] array, int L, int R){
        if(L>R){
            return new int[]{-1, -1};
        }
        if(L==R){
            return new int[]{L, R};
        }
        int less = L-1;
        int more = R;
        int index = L;
        int target = array[R];
        while (index < more) {
            if(array[index] == target) {
                index ++;
            } else if (array[index] < target) {
                swap(array, ++less, index++);
            } else {
                more--;
                swap(array, index, more);
            }
        }
        swap(array, more, R);
        return new int[] {less+1, more};
    }

    public static void process(int[] array, int L, int R) {
        if(L >= R){
            return;
        }
        int[] result = subSort(array, L, R);
        Print(array);
        process(array, L, result[0]-1);
        process(array, result[1]+1, R);
    }

    public static void sortV1(int[] array) {

        process(array, 0 , array.length-1);
    }


    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void Print(int[] array) {
        for (int j : array) {
            System.out.printf(j + ",");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] array={1,2,3,8,3,5,7,6,3};
        Print(array);
//        int[] result=subSort(array,0, array.length-1);
        sortV1(array);
        Print(array);
//        Print(result);
    }
}
