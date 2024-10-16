package com.jackiewang.algorithm.dp;

public class robotWalk {
    //一行N个位置，1~N,N一定大于或者等于2
    //开始机器在M位置上
    //机器人来到1位置，下一步只能往右来到2位置
    //机器人来到N位置，下一步只能往左来到N-1位置
    //机器人来到中间位置，那么下一步可以往左走或者往右走
    //机器人必须走K步，最终能到P为止，方法有多少种，给定四个参数N，M，K，P，返回方法数。



    public static int walk(int N, int M, int K, int P) {
        return way1(M, P, K, N);
    }

    private static int way1(int m, int p, int k, int n) {
        if(k == 0 ) {
            if (m==p) {
                return 1;
            } else {
                return 0;
            }
        }
        if(m==1) {
            return way1(2, p, k-1, n);
        }
        if(m==n){
            return way1(n-1, p, k-1, n);
        }
        return way1(m-1, p, k-1, n) + way1(m+1, p, k-1, n);
    }

    public static void main(String[] args) {
        System.out.println(way1(4,2,4,4));
    }
}
