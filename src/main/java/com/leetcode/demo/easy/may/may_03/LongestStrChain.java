package com.leetcode.demo.easy.may.may_03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStrChain {

    public static void main(String[] args) {
        // 输入：words = ["a","b","ba","bca","bda","bdca"]
        //输出：4

        String[] words = {"abcd","dbqca"};
        System.out.println(new LongestStrChain().longestStrChain(words));

        // 输入：words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
        //输出：5

        // 输入：words = ["abcd","dbqca"]
        //输出：1

    }

    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
//        System.out.println(Arrays.toString(words));
        int max = 1;
        int minLen = words[0].length();
        for (String word : words) {
            int tmpLen = 1;
            if (word.length()>minLen) {
                for (int i = 0; i < word.length(); i++) {
                    String s = word.substring(0, i) + word.substring(i + 1);
                    tmpLen = Math.max(tmpLen, map.getOrDefault(s, 0) + 1);
                }
                max = Math.max(max, tmpLen);
            }
            map.put(word, tmpLen);
        }
//        System.out.println(map);
        return max;
    }
}
