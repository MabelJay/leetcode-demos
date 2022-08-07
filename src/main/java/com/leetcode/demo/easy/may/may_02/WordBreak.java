package com.leetcode.demo.easy.may.may_02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreak {
    public static void main(String[] args) {
        // 输入: s = "leetcode", wordDict = ["leet", "code"]
        //输出: true

        // 输入: s = "applepenapple", wordDict = ["apple", "pen"]
        //输出: true

        // 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        //输出: false

        String s = "leetcode";
        System.out.println(s.substring(0, s.length()));
        String[] wordDict = {"leet", "code"};
        List<String> list = Arrays.stream(wordDict).collect(Collectors.toList());
        System.out.println(new WordBreak().wordBreak(s, list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }
}
