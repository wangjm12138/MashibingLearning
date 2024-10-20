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

    //    0  1      2      3      4
    // 0  x  x      x      x      x
    // 1  0 (2,0)  (2,1)  (2,2)  (2,3)
    // 2  0 (1,0)+(3,0)
    // 3  0
    // 4  1 (3,0)  (3,1)  (3,2)  (3,3)
    //dp表格,行编号代表从哪个位置触发，列表示还剩步数为几步，值为有几种方式到达目标点
    //因为位置是从1开始，所以第一行都不要
    //而根据暴力递归方法，当在第一个位置时候，依赖第二个位置，并且步数减1， 同理，到达最大第四个位置时候，依赖于第三步，步数减1
    //而中间的位置,即依赖后一步，步数减一，也依赖于前一步，步数减一，所以根据这样，按照列的方式把表格填满就可以了
    private static int way2(int m, int p, int k, int n) {
        int[][] dp = new int[n+1][k+1];
        dp[4][0] = 1;

        for(int i = 1; i <= k; i++) {
            dp[1][i] = dp[2][i-1];
            for (int j=1; j< n; j++) {
                dp[j][i] = dp[j+1][i-1] + dp[j-1][i-1];
            }
            dp[n][i] = dp[n-1][i-1];
        }
        return dp[m][k];
    }

    public static void main(String[] args) {
        System.out.println(way1(2,4,4,4));
        System.out.println(way2(2,4,4,4));
    }
}
