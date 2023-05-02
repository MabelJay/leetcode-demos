package com.leetcode.demo.apr.day17;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {

    public static void main(String[] args) {
        // 输入：s = "babad"
        //输出："bab"
        //解释："aba" 同样是符合题意的答案。

        String s = "ac";
        System.out.println(new LongestPalindrome().longestPalindrome2(s));
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return "";
        int len = s.length();
        if (len < 2) return s;

        int beginIndex = 0;
        int maxLen = 1;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] arr = s.toCharArray();
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = L + i - 1;
                if (j > len - 1) break;

                if (arr[i] != arr[j]) dp[i][j] = false;
                else {
                    if (j - i < 3) dp[i][j] = true;
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && L > maxLen) {
                    maxLen = L;
                    beginIndex = i;
                }
            }
        }

        return s.substring(beginIndex, beginIndex + maxLen);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        System.out.println(sb);
        s = sb.toString();

        List<Integer> armList = new ArrayList<>();
        int start = 0, end = -1;
        int j = -1, right = -1;

        for (int i = 0; i < s.length(); i++) {
            int cur;
            if (i >= right) {
                cur = expand(s, i, i);
            } else {
                int symPoint = 2 * j - i;
                int minArm = Math.min(armList.get(symPoint), right - i);
                cur = expand(s, i - minArm, i + minArm);
            }
            armList.add(cur);
            if (2 * cur + 1 > end - start) {
                start = i - cur;
                end = i + cur;
            }
            if (i + cur > right) {
                j = i;
                right = i + cur;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != '#') res.append(s.charAt(i));
        }
        return res.toString();
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (right - left - 2) / 2;
    }
}
