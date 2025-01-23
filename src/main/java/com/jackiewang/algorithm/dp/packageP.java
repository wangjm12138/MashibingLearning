package com.jackiewang.algorithm.dp;

public class packageP {

    public static void main(String[] args) {
        int[] weight = {2,12,4,16,7,8,26,23};
        int[] value = {2,3,1,6,63,21,42,1};
        mostValue(weight,value,45);
    }

    private static int mostValue(int[] weight, int[] value, int bag) {

        return process(weight,value,bag,0);
    }

    private static int process(int[] weight, int[] value, int bag, int pos) {

        if(pos >= weight.length-1){
            return 0;
        }
        if(bag < 0) {
            return 0;
        }

        return Math.max(process(weight,value,bag,pos+1), value[pos]+process(weight,value,bag-weight[pos],pos+1));

    }

}
