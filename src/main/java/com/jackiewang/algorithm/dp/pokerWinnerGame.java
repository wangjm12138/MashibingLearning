package com.jackiewang.algorithm.dp;

//给定一个整型数组arr，代表数值不同的纸牌排成一条线
//玩家A和玩家B依次拿走每张纸牌
//规定玩家A先拿，玩家B后拿
//但是每个玩家每次只能拿走最左或最右的纸牌
//玩家A和玩家B都绝顶聪明
//请返回最后获胜者的分数
public class pokerWinnerGame {

    //在L和R上面后手最大的数值
    public static int g(int[] poker, int L, int R){
        if (L>R) {
            return 0;
        }

        int max;
        if(L==R) {
            return 0;
        } else if (L==R-1) {
            max = Math.min(poker[L], poker[R]);
        } else {
            max = Math.min(f(poker, L+1, R), f(poker, L, R-1));
        }
        return max;

    }

    //在L和R上先手最大数值
    public static int f(int[] poker, int L, int R){
        if (L>R) {
            return 0;
        }

        int max;
        if(L==R) {
            max =  poker[L];
        } else if (L==R-1) {
            max = Math.max(poker[L], poker[R]);
        } else {
            max = Math.max(poker[L] + g(poker, L+1, R), poker[R] + g(poker, L, R-1));
        }
        return max;
    }

    //改动态规划
    public static int dp(int[] poker){
        int[][] fdp = new int[poker.length][poker.length];
        int[][] gdp = new int[poker.length][poker.length];

        for(int i = 0; i < poker.length; i++){
            fdp[i][i] = poker[i];
            gdp[i][i] = 0;
            if(i+1 < poker.length) {
                fdp[i][i + 1] = Math.max(poker[i], poker[i + 1]);
                gdp[i][i + 1] = Math.min(poker[i], poker[i + 1]);
            }
        }
        for(int i = 2; i < poker.length; i++){
            int row = 0;
            int col = i;
            while(col < poker.length) {
                fdp[row][col] = Math.max(poker[row] + gdp[row+1][col], poker[col] + gdp[row][col-1]);
                gdp[row][col] = Math.min(fdp[row+1][col], fdp[row][col-1]);
                row++;
                col++;
            }

        }
        return Math.max(fdp[0][poker.length-1], gdp[0][poker.length-1]);
//        return 1;
    }

    public static int winner(int[] poker){
        if (poker == null || poker.length == 0) return 0;

        int fmax = f(poker, 0, poker.length - 1);
        int gmax = g(poker, 0, poker.length - 1);

        return Math.max(fmax, gmax);
    }


    public static void main(String[] args) {
            int[] poker = new int[]{4,2,6,3,8};

            int max  = winner(poker);

        System.out.println(max);
            int max2 = dp(poker);
        System.out.println(max2);
    }
}
