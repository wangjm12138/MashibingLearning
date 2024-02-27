package com.jackiewang;
public class Test {

    private static class SortRevise{

        public static void SelectSort(int[] arr){
            int length = arr.length;
            if (arr.length == 0) {
                return;
            }
            // 0, 1 ~ N
            // 1, 2 ~ N
            // 2, 3 ~ N
            // N-1, N
            int minValuePo;
            for (int i = 0; i < length; i++) {
                minValuePo = i;
                for (int j = i + 1; j < length; j++) {
                    minValuePo = (arr[j] < arr[minValuePo]) ? j:minValuePo;
                }
                swap(arr, i, minValuePo);
            }
        }


        //
        // 0,  0-1, 1-2, 2,3 ... (N-3)-(N-2), (N-2)-(N-1)
        // 1,  0-1, 1-2, 2,3 ... (N-3)-(N-2)
        // N-1,0
        public static void BubbleSort(int[] arr){
            if (arr.length == 0) {
                return;
            }
            int length = arr.length;
            for (int i = 0; i < length; i++) {
                for (int j = 1; j < length - i; j++) {
                    if(arr[j-1] > arr[j])
                        swap(arr, j, j-1);
                }
            }

        }

        
        // 0,   0
        // 1,   0, 1
        // 2,   0, 1, 2
        // N-1, 0, 1, 2 ..., N-1
        public static void InsertSort(int[] arr){
            if (arr.length == 0) {
                return;
            }
            int length = arr.length;
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; (j >0 ) &&(j < length)&& (arr[j] < arr[j-1]); j--) {
                    if(arr[j] < arr[j-1])
                        swap(arr, j,j-1);
                }
            }
        }

        public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] =  arr[j];
            arr[j] = temp;
        }

    }

    public static void print(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ,");
        }
        System.out.println();
    }

//    public static void main(String[] args) {
//            int[] arr = {2,1,3,11, 5, 4,12, 6,7,9};
//            print(arr);
//            main.io.SortRevise.InsertSort(arr);
//            print(arr);
//    }
    


}
