package com.leetcode.demo.easy.mar.mar_28;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountPalindromicSubsequence {

    public static void main(String[] args) {
        // 输入：s = "aabca"
        //输出：3
        String s = "aabca";
        String s1 = "adc";
        String s2 = "bbcbaba";
        String s3 = "tlpjzdmtwderpkpmgoyrcxttiheassztncqvnfjeyxxp";
        System.out.println(new CountPalindromicSubsequence().countPalindromicSubsequence(s));
        System.out.println(new CountPalindromicSubsequence().countPalindromicSubsequence(s1));
        System.out.println(new CountPalindromicSubsequence().countPalindromicSubsequence(s2));
        System.out.println(new CountPalindromicSubsequence().countPalindromicSubsequence(s3));
    }

    public int countPalindromicSubsequence2(String s) {
        int len = s.length();
        int index = 1;
        Set<String> set = new HashSet<>();
        while (index < len - 1) {
            int left = index - 1;
            int right = index + 1;
            Set<Character> set2 = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            while (left >= 0 && set2.add(s.charAt(left))) {
                while (right < len) {
                    if (s.charAt(left) == s.charAt(right)) {
                        sb.append(s.charAt(index)).append(s.charAt(left)).append(s.charAt(right));
                        set.add(sb.toString());
                        sb = new StringBuilder();
                    }
                    right++;
                }
                right = index + 1;
                left--;
            }
            index++;
        }
        return set.size();
    }

    public int countPalindromicSubsequence(String s) {
        int len = s.length();
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                int[] arr = map.get(temp);
                arr[1] = i;
            } else {
                int[] arr = new int[2];
                arr[0] = i;
                map.put(temp, arr);
            }
        }

        int count = 0;
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (arr[1] != 0) {
                Set<Character> set = new HashSet<>();
                for (int index = arr[0] + 1; index < arr[1]; index++) {
                    if (set.add(s.charAt(index))) count++;
                }
            }
        }
        return count;
    }
}
