package com.jackiewang.algorithm.dp;

public class stringConversion {

    public static int conversion1(String a){
        if(a == null || a.isEmpty())
            return 0;

        return way1(a,0);
    }

    public static int conversion2(String a){
        if(a == null || a.isEmpty()) {
            return 0;
        }
        return way2(a);
//        return way1(a,0);
    }
    // 1 'A'
    // 2 'B'
    // 3 'C'
    //
    //  10 'J'
    //  20 ‘’
    //... 26 'Z'
    // 112456
    private static int way1(String a, int start) {
        if(start > a.length()) {
            return 0;
        }
        if(start == a.length()) {
            return 1;
        }
        if(a.charAt(start) == '0') {
            System.out.println("charat"+start);
            return 0;
        }
        int p = way1(a, start + 1);


        if( start  < a.length()-1 && (((a.charAt(start) - '0') * 10 + (a.charAt(start+1) - '0')) < 27) ) {
            p +=  way1(a, start + 2);
        }
        return p;
    }

    //之前有疑问为什么dp[N]要赋值为1，而不是dp[N-1]为1，其实这里自己思考错误了，虽然dp[N-1]已经是最后一步了，但是此时还没判断是否字符满足需求，所以
    //也就是说判断标准要变成，是否能到下一步才能知道整体全部完美转换了，也就是和上面暴力递归一样，当到了start能到了比字符串多一个时候，才判断为1.
    //这边的dp表示从这个位置触发，到最终为止，有多少种可能性，要是这个位置为'0‘，就表示没有可能性到达最终位置。
    private static int way2(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        char[] str  = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N+1];
        dp[N] = 1;

        for(int i = N-1; i >= 0; i--) {
            if(str[i] == '0') {
                dp[i] = 0;
                continue;
            }
            int p = dp[i+1]; //只要不等于0，至少有一种可以到达比字符串更长的位置。
            if(i+1 < N &&((str[i] - '0') * 10 + str[i+1] - '0' < 27) ) {
                p +=  dp[i+ 2];
            }
            dp[i] = p;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String a = "1110";
        //System.out.println(a.charAt(3));
        System.out.println(conversion1(a));
//        System.out.println(conversion2(a));
//        System.out.println(a.charAt(0));
    }

}
