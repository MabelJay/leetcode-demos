package com.leetcode.demo.easy.apr.apr_09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStrChain {

    public static void main(String[] args) {
        // 输入：words = ["a","b","ba","bca","bda","bdca"]
        //输出：4
        //解释：最长单词链之一为 ["a","ba","bda","bdca"]

        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};

        // 输入：words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
        //输出：5

        // 输入：words = ["abcd","dbqca"]
        //输出：1
        String[] words2 = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};

        String[] words3 = {"abcd", "dbqca"};

        //["ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"]
        String[] word4 = {"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"};
        System.out.println(new LongestStrChain().longestStrChain(words));
        System.out.println(new LongestStrChain().longestStrChain(words2));
        System.out.println(new LongestStrChain().longestStrChain(words3));
        System.out.println(new LongestStrChain().longestStrChain2(word4));
    }

    public int longestStrChain(String[] words) {
        int len = words.length;
        if (len == 1) return 1;

        Arrays.sort(words, (Comparator.comparingInt(String::length)));
        System.out.println(Arrays.toString(words));
        int[] dp = new int[len];
        dp[0] = 1;
        int index = 1;
        int max = dp[0];
        while (index < len) {
            dp[index] = 1;
            for (int i = 0; i < index; i++) {
                if (isPreviousStr(words[index], words[i])) {
                    dp[index] = Math.max(dp[index], dp[i] + 1);
                }
            }
            max = Math.max(dp[index], max);
            index++;
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    public boolean isPreviousStr(String query, String pattern) {
        if (query.length() - pattern.length() != 1) return false;
        int diff = 0;
        int index1 = 0, index2 = 0;
        while (index1 < query.length() && index2 < pattern.length()) {
            if (query.charAt(index1) == pattern.charAt(index2)) {
                index2++;
            } else {
                diff++;
            }
            index1++;
            if (diff > 1) return false;
        }
        return index2 == pattern.length();
    }

    public int longestStrChain2(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int minVal = words[0].length(), maxLen = 1;
        for (String word : words) {
            int m = word.length();
            int len = 1;
            if (m > minVal) {
                for (int i = 0; i < m; i++) {
                    String s = word.substring(0, i) + word.substring(i + 1);
                    len = Math.max(len, map.getOrDefault(s, 0) + 1);
                }
            }
            maxLen = Math.max(maxLen, len);
            map.put(word, len);
        }
        return maxLen;
    }
}
