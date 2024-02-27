package com.jackiewang.algorithm;
public class SortRevise {

    public static void SelectionSort(int[] arr) {
        if (arr == null || arr.length <=1) {
            return;
        }
        //1 N-1
        //2 N-2
        //3 N-3
        for(int i = 0; i < arr.length; i++) {
            int minValuePos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minValuePos = arr[j] < arr[minValuePos] ? j: minValuePos;
            }
            swap(arr, i, minValuePos);
        }

    }

    public static void BubbleSort(int[] arr) {
        if (arr == null || arr.length <=1) {
            return;
        }
        // 0 1 | 1 2 | 2 3 | ...  N-2 | N-1, N-1 次比较, 1
        // 0 1 | 1 2 | 2 3 | ...  N-3 | N-2, N-2 次比较, 2
        // 0 1,                               1 次比较,  N-1
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j-1] > arr[j]) {
                    swap(arr,j,j-1);
                }
            }
        }

    }

    public static void InsertSort(int[] arr) {
        if (arr == null || arr.length <=1) {
            return;
        }
        // arr0 arr1
        // arr0 arr1 arr2
        // 0 1 2 3
        //
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && (arr[j]<arr[j-1]); j--) {
                swap(arr,j,j-1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

//    public static void main(String[] args) {
//        int[] arr= {1,20,3,12,46,23,2,7,15,67,90};
//        print(arr);
//        //SelectionSort(arr);
//        //BubbleSort(arr);
//        InsertSort(arr);
//        print(arr);
//    }
}
