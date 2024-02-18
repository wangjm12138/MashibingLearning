//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minValueLoc = i;
            for (int j = i + 1; j < arr.length; j++) {
                minValueLoc = arr[j] < arr[minValueLoc]? j:minValueLoc;
            }
            swap(arr,i,minValueLoc);
        }

    }

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j] < arr[j-1])
                    swap(arr,j-1,j);
            }
        }
    }

    public static void insertSort(int[] arr){


        for (int end=1; end < arr.length; end++) {

            for (int j = end - 1;  j >= 0 && arr[end] < arr[j]; j--) {
                swap(arr, end, j);
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr={1,21,5,7,10,15};
        print(arr);
        //selectSort(arr);
        //bubbleSort(arr);
        insertSort(arr);
        print(arr);
        //print(arr);
        //bubbleSort(arr);
    }
}