package com.leetcode.demo.easy.mar.mar_26;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CanConstruct {

    public static void main(String[] args) {
        // 输入：s = "annabelle", k = 2
        //输出：true

        // 输入：s = "leetcode", k = 3
        //输出：false

        String s = "annabelle";
        String s1 = "leetcode";
        // 输入：s = "true", k = 4
        //输出：true
        String s2 = "true";

        // 输入：s = "yzyzyzyzyzyzyzy", k = 2
        //输出：true
        String s3 = "cr";
        System.out.println(new CanConstruct().canConstruct(s, 2));
        System.out.println(new CanConstruct().canConstruct(s1, 3));
        System.out.println(new CanConstruct().canConstruct(s2, 4));
        System.out.println(new CanConstruct().canConstruct(s3, 7));

        System.out.println(new CanConstruct().canConstruct2(s, 2));
    }

    public boolean canConstruct(String s, int k) {
        int len = s.length();
        if (len < k) return false;
        if (len == k) return true;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char temp = s.charAt(i);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        int count = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            if (frequency % 2 != 0) count++;
        }

        return count <= k;
    }

    public boolean canConstruct2(String s, int k) {
        int len = s.length();
        if (len < k) return false;
        if (len == k) return true;

        int[] cnt = new int[26];
        for (int i = 0; i < len; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 != 0) count++;
        }

        return count <= k;
    }
}
