package com.leetcode.demo.easy.june.june_04;

public class MinFlipsMonoIncr {
    public static void main(String[] args) {
        // 输入：s = "00110"
        //输出：1
        String s = "0101100011";
        // t t f t t f t t t t t
        System.out.println(new MinFlipsMonoIncr().minFlipsMonoIncr(s));
    }

    public int minFlipsMonoIncr(String s) {
        if (s == null || s.length() == 0) return 0;

        int countOne = 0;
        int dp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                dp = Math.min(dp + 1, countOne);
            } else {
                countOne++;
            }
        }
        return dp;
    }
}
