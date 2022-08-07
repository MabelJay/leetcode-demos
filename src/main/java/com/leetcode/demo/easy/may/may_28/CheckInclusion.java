package com.leetcode.demo.easy.may.may_28;

import java.util.Arrays;

public class CheckInclusion {

    public static void main(String[] args) {
        // 输入: s1 = "ab" s2 = "eidbaooo"
        //输出: True
        //解释: s2 包含 s1 的排列之一 ("ba").

        // 输入: s1= "ab" s2 = "eidboaoo"
        //输出: False

        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(new CheckInclusion().checkInclusion2(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) return false;
        int[] countArr1 = new int[26];
        int[] countArr2 = new int[26];
        for (int i = 0; i < n; i++) {
            int index1 = s1.charAt(i) - 'a';
            int index2 = s2.charAt(i) - 'a';
            countArr1[index1]++;
            countArr2[index2]++;
        }

        if (Arrays.equals(countArr1, countArr2)) return true;
        for (int i = n; i < m; i++) {
            int index = s2.charAt(i) - 'a';
            countArr2[index]++;
            countArr2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(countArr1, countArr2)) return true;
        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) return false;

        int[] countArr = new int[26];
        for (int i = 0; i < n; i++) {
            int index = s1.charAt(i) - 'a';
            countArr[index]++;
        }

        int left = 0, right = 0;
        while (right < m) {
            int index = s2.charAt(right) - 'a';
            countArr[index]--;
            while (countArr[index] < 0) {
                countArr[s2.charAt(left) - 'a']++;
                left++;
            }
            if (right - left + 1 == n) return true;
            right++;
        }
        return false;
    }
}
