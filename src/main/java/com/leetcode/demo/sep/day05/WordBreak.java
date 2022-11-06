package com.leetcode.demo.sep.day05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        // 输入: s = "leetcode", wordDict = ["leet", "code"]
        //输出: true

        // 输入: s = "applepenapple", wordDict = ["apple", "pen"]
        //输出: true

        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(new WordBreak().wordBreak(s, list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;

        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();

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
