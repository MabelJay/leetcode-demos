package com.leetcode.demo.oct.day28;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreak {
    public static void main(String[] args) {
        // 输入: s = "leetcode", wordDict = ["leet", "code"]
        //输出: true

        // 输入: s = "applepenapple", wordDict = ["apple", "pen"]
        //输出: true

        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) return false;
        int len = s.length();

        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}