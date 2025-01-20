package com.jackiewang.algorithm.dp;

import java.util.HashMap;

public class sticker {

    //给定一个字符str，给定一个字符类型的数组arr,出现的字符都是小写英文
    //arr每一个字符串，代表一张贴纸，你可以把单个字符剪开头使用，目的是拼出str来
    //返回需要至少多少张贴纸可以完成这个任务

    public static int minusStickers(String[] stickers,String target){
        if(target == null || target.isEmpty())
            return 0;

        int ans = way1(stickers, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    //返回有最少需要多少张贴纸完成任务
    public static int way1(String[] stickers, String target){
        if(target.isEmpty()){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(String first : stickers){
            String rest = minus(first, target);
            if(rest.length() != target.length()){
                min = Math.min(min, way1(stickers, rest));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    public static String minus(String sticker, String target){
        char[] caseArr = target.toCharArray();
        char[] stickerArr = sticker.toCharArray();
        int[] count = new int[26];

        for(char cha: caseArr){
            count[cha - 'a']++;
        }

        for(char cha: stickerArr){
            count[cha - 'a']--;
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<26; i++){
            if(count[i] > 0){
                sb.append(String.valueOf((char) ('a' + i)).repeat(Math.max(0, count[i])));
            }
        }

        return sb.toString();
    }
    public static int minusStickers2(String[] stickers,String target){
        if(target == null || target.isEmpty())
            return 0;
        int N = stickers.length;
        int[][] counts = new int[N][26];
        for(int i=0; i < N; i++){
            char[] str = stickers[i].toCharArray();
            for(char cha: str) {
                counts[i][cha - 'a']++;
            }
        }

        int ans = way2(counts, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    //返回有最少需要多少张贴纸完成任务
    public static int way2(int[][] stickers, String target){
        if(target.length() == 0){
            return 0;
        }
        char[] targetArr = target.toCharArray();
        int[] tcounts = new int[26];
        for(char cha: targetArr){
            tcounts[cha - 'a']++;
        }
        int N = stickers.length;
        int min = Integer.MAX_VALUE;
        for(int i=0; i < N; i++){
            int[] stickerArr = stickers[i];
            if(stickerArr[targetArr[0] - 'a'] > 0){
                StringBuilder builder = new StringBuilder();
                for(int j = 0;j < 26; j++){
                    if(tcounts[j] > 0){
                        int nums = tcounts[j] - stickerArr[j];
                        for(int k = 0; k < nums; k++){
                            builder.append((char)(j+'a'));
                        }
                    }
                }
                String rest = builder.toString();
                min = Math.min(min, way2(stickers, rest));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    public static int minusStickers3(String[] stickers,String target){
        if(target == null || target.isEmpty())
            return 0;
        int N = stickers.length;
        int[][] counts = new int[N][26];
        for(int i=0; i < N; i++){
            char[] str = stickers[i].toCharArray();
            for(char cha: str) {
                counts[i][cha - 'a']++;
            }
        }
        HashMap<String, Integer> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("", 0);
        int ans = way3(counts, target, objectObjectHashMap);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public static int way3(int[][] stickers, String target, HashMap<String, Integer> dp){
        if(dp.containsKey(target)){
            return dp.get(target);
        }
        char[] targetArr = target.toCharArray();
        int[] tcounts = new int[26];
        for(char cha: targetArr){
            tcounts[cha - 'a']++;
        }
        int N = stickers.length;
        int min = Integer.MAX_VALUE;
        for(int i=0; i < N; i++){
            int[] stickerArr = stickers[i];
            if(stickerArr[targetArr[0] - 'a'] > 0){
                StringBuilder builder = new StringBuilder();
                for(int j = 0;j < 26; j++){
                    if(tcounts[j] > 0){
                        int nums = tcounts[j] - stickerArr[j];
                        for(int k = 0; k < nums; k++){
                            builder.append((char)(j+'a'));
                        }
                    }
                }
                String rest = builder.toString();
                min = Math.min(min, way3(stickers, rest, dp));
            }
        }
        int ans =  min + (min == Integer.MAX_VALUE ? 0 : 1);
        dp.put(target, ans);
        return ans;
    }

    public static void main(String[] args) {
        String[] stickers = {"with","example","science"};
        int ans  = minusStickers3(stickers,"thehat");
        System.out.println(ans);
    }
}
