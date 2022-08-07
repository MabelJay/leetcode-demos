package com.leetcode.demo.easy.may.may_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {

    public static void main(String[] args) {
        // 输入: s = "cbaebabacd", p = "abc"
        //输出: [0,6]

        // 输入: s = "abab", p = "ab"
        //输出: [0,1,2]

        String s = "abab";
        String p = "ab";
        System.out.println(new FindAnagrams().findAnagrams2(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        List<Integer> list = new ArrayList<>();
        if (n > m) return list;

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            cnt1[s.charAt(i) - 'a']++;
            cnt2[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2)) {
            list.add(0);
        }

        for (int i = n; i < m; i++) {
            cnt1[s.charAt(i) - 'a']++;
            cnt1[s.charAt(i - n) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) {
                list.add(i - n + 1);
            }
        }
        return list;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (m < n) return list;

        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[p.charAt(i) - 'a']++;
        }
        int left = 0, right = 0;
        while (right < m) {
            int index = s.charAt(right) - 'a';
            cnt[index]--;
            while (cnt[index] < 0) {
                cnt[s.charAt(left) - 'a']++;
                left++;
            }
            if (right - left + 1 == n) {
                list.add(left);
            }
            right++;
        }
        return list;
    }
}
