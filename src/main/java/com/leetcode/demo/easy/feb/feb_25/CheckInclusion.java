package com.leetcode.demo.easy.feb.feb_25;

import java.util.Arrays;

public class CheckInclusion {

    public static void main(String[] args) {
        // 输入：s1 = "ab" s2 = "eidbaooo"
        //输出：true
        //解释：s2 包含 s1 的排列之一 ("ba").

        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(new CheckInclusion().checkInclusion3(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len2 < len1) return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < len1; i++) {
            arr1[s1.charAt(i) - 97]++;
            arr2[s2.charAt(i) - 97]++;
        }
        if (Arrays.equals(arr1, arr2)) return true;
        // window size is k
        for (int i = len1; i < len2; i++) {
            arr2[s2.charAt(i) - 97]++;
            arr2[s2.charAt(i - len1) - 97]--;
            if (Arrays.equals(arr1, arr2)) return true;
        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len2 < len1) return false;

        int[] arr = new int[26];
        for (int i = 0; i < len1; i++) {
            arr[s1.charAt(i) - 97]--;
            arr[s2.charAt(i) - 97]++;
        }

        int diff = 0;
        for (int val : arr) {
            if (val != 0) diff++;
        }
        if (diff == 0) return true;

        for (int i = len1; i < len2; i++) {
            int x = s2.charAt(i) - 97;
            int y = s2.charAt(i - len1) - 97;

            if (arr[x] == 0) {
                diff++;
            }
            arr[x]++;
            if (arr[x] == 0) {
                diff--;
            }

            if (arr[y] == 0) {
                diff++;
            }
            arr[y]--;
            if (arr[y] == 0) {
                diff--;
            }

            if (diff == 0) return true;
        }
        return false;
    }

    public boolean checkInclusion3(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) return false;
        int[] arr = new int[26];

        for (int i = 0; i < len1; i++) {
            arr[s1.charAt(i) - 97]--;
        }

        int left = 0;
        for (int right = 0; right < len2; right++) {
            int val = s2.charAt(right) - 97;
            arr[val]++;
            while (arr[val] > 0) {
                arr[s2.charAt(left) - 97]--;
                left++;
            }

            if (right - left + 1 == len1) return true;
        }
        return false;
    }
}
